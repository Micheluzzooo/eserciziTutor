package com.example.unitTest;

import com.example.unitTest.controller.UtenteController;
import com.example.unitTest.entity.Utente;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@ActiveProfiles(value = "test")
@AutoConfigureMockMvc
class UtenteControllerTest {

	@Autowired
	private UtenteController utenteController;

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void utenteControllerLoads() {
		assertThat(utenteController).isNotNull();
	}

	private Utente createUtente() throws Exception {
		Utente utente = new Utente();
		utente.setName("Michele");
		utente.setEmail("miche@gmail.com");

		return createUtente(utente);
	}

	private Utente createUtente(Utente utente) throws Exception {
		MvcResult result = createUtenteRequest(utente);
		Utente utenteFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), Utente.class);

		assertThat(utenteFromResponse.getName()).isEqualTo(utente.getName());
		assertThat(utenteFromResponse.getEmail()).isEqualTo(utente.getEmail());
		assertThat(utenteFromResponse).isNotNull();
		assertThat(utenteFromResponse.getId()).isNotNull();

		return utenteFromResponse;
	}

	private MvcResult createUtenteRequest() throws Exception {
		Utente utente = new Utente();
		utente.setName("Michele");
		utente.setEmail("miche@gmail.com");
		return createUtenteRequest(utente);
	}

	private MvcResult createUtenteRequest(Utente utente) throws Exception {
		if (utente == null) return null;
		String userJSON = objectMapper.writeValueAsString(utente);

		return this.mockMvc.perform(post("/utente/createUtente")
						.contentType(MediaType.APPLICATION_JSON)
						.content(userJSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

	}

	@Test
	void createUtenteTest() throws Exception {
		Utente utenteFromResponse = createUtente();
	}

	@Test
	void readUtenteList() throws Exception {
		createUtenteRequest();

		MvcResult result = this.mockMvc.perform(get("/utente/getAll"))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		List<Utente> utentiFromResponse = objectMapper.readValue(result.getResponse().getContentAsString(), List.class);
		System.out.println("Gli utenti nel database sono: " + utentiFromResponse.size());
		assertThat(utentiFromResponse.size()).isNotZero();
	}

	@Test
	void readSingleUtente() throws Exception {
		Utente utente = createUtente();
		Utente utenteFromResponse = getUtenteFromId(utente.getId());
		assertThat(utenteFromResponse.getId()).isEqualTo(utente.getId());

	}

	@Test
	void updateUtente() throws Exception {
		Utente utente = createUtente();

		String newName = "Mario";
		utente.setName(newName);
		String userJSON = objectMapper.writeValueAsString(utente);


		MvcResult resultOne = this.mockMvc.perform(put("/utente/setUtente/" + utente.getId())
						.contentType(MediaType.APPLICATION_JSON)
						.content(userJSON))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();
		Utente utenteFromResponse = objectMapper.readValue(resultOne.getResponse().getContentAsString(), Utente.class);


		assertThat(utenteFromResponse.getId()).isEqualTo(utente.getId());
		assertThat(utenteFromResponse.getName()).isEqualTo(newName);


		Utente utenteFromResponseGet = getUtenteFromId(utente.getId());
		assertThat(utenteFromResponseGet.getId()).isEqualTo(utente.getId());
		assertThat(utenteFromResponseGet.getName()).isEqualTo(newName);
	}

	@Test
	void deleteUtente() throws Exception {
		Utente utente = createUtente();
		assertThat(utente.getId()).isNotNull();

		this.mockMvc.perform(delete("/utente/deleteById/" + utente.getId()))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		Utente utenteFromResponseGet = getUtenteFromId(utente.getId());
		assertThat(utenteFromResponseGet).isNull();
	}

	private Utente getUtenteFromId(Long id) throws Exception {
		MvcResult result = this.mockMvc.perform(get("/utente/getUtente/" + id))
				.andDo(print())
				.andExpect(status().isOk())
				.andReturn();

		try {
			String userJSON = result.getResponse().getContentAsString();
			Utente utente = objectMapper.readValue(userJSON, Utente.class);

			assertThat(utente).isNotNull();
			assertThat(utente.getId()).isNotNull();
			return utente;

		} catch (Exception e) {
			return null;
		}
	}

}
