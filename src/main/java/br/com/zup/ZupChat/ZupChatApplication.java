package br.com.zup.ZupChat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ZupChatApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZupChatApplication.class, args);
	}

}
