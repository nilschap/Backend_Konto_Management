package com.example.bankaccountmanagement;

import com.example.bankaccountmanagement.AccountDomain.InputedAccount;
import com.example.bankaccountmanagement.Controller.AccountMgController;
import com.example.bankaccountmanagement.Controller.UserMgController;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.nio.charset.Charset;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BankaccountmanagementApplicationTests {

	@Autowired
	private AccountMgController accountMgController;
	@Autowired
	private UserMgController userMgController;

	//Überprüfen ob die Applikation korrekt geladen wird
	@Test
	public void contextLoads(){}

	//Tested ob AccountMgController correkt geladen wird
	@Test
	public void Isaccountcontrollerworking() throws Exception {
		assertThat(accountMgController).isNotNull();
	}

	//Tested ob UserMgController correkt geladen wird
	@Test
	public void Isusermgcontrollerworking() throws Exception {
		assertThat(userMgController).isNotNull();
	}

	//Spring integrierte library um daten zu mocken
	private MockMvc mockMvc;

	//Mocken von requestBody Tutorial link : https://developer.mozilla.org/en-US/docs/Web/HTTP/Messages#Body
	public static final MediaType APPLICATION_JSON_UTF8 = new MediaType(MediaType.APPLICATION_JSON.getType(), MediaType.APPLICATION_JSON.getSubtype(), Charset.forName("utf8"));

	//Aus dem Objekt wird ein Json erstellt und dann als Request body an den Controller gesendet
	@Test
	public void checkifcreatingnewaccountisworking() throws Exception {
		String url = "http://localhost:8080/accounts" ;
		InputedAccount inputedAccount = new InputedAccount();
		inputedAccount.setBalance(30);
		inputedAccount.setIban("12312321312312324");
		inputedAccount.setName("SavingAccount");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.WRAP_ROOT_VALUE, false);
		ObjectWriter ow = mapper.writer().withDefaultPrettyPrinter();
		String requestJson=ow.writeValueAsString(inputedAccount);

		mockMvc.perform(post(url).contentType(APPLICATION_JSON_UTF8)
				.content(requestJson))
				.andExpect(status().isCreated());
	}
}
