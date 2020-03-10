package com.nt.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Import;

import com.nt.beans.Player;
import com.nt.config.AppConfig;

@SpringBootApplication
@Import(AppConfig.class)
public class IocBootProj82StrategyDpApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=null;
		Player player=null;
		//get IOC container
		ctx=SpringApplication.run(IocBootProj82StrategyDpApplication.class, args);
		//get TagetBean class object
		player=ctx.getBean("player",Player.class);
		//invoke method
		player.playGame();
		//close container
		((ConfigurableApplicationContext) ctx).close();
		
	}

}
