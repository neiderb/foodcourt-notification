package com.foodcourt.notification.infrastructure.adapters.sns.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

@Configuration
public class SnsClientConfig {
	
	@Bean
	public SnsClient snsClient(SnsProperties properties) {
		return SnsClient.builder()
			.region(Region.of(properties.region()))
			.credentialsProvider(getProviderChain())
			.build();
	}
	
	private AwsCredentialsProviderChain getProviderChain() {
		return AwsCredentialsProviderChain.builder()
			.addCredentialsProvider(EnvironmentVariableCredentialsProvider.create())
			.addCredentialsProvider(SystemPropertyCredentialsProvider.create())
			.addCredentialsProvider(WebIdentityTokenFileCredentialsProvider.create())
			.addCredentialsProvider(ProfileCredentialsProvider.create())
			.addCredentialsProvider(ContainerCredentialsProvider.builder().build())
			.addCredentialsProvider(InstanceProfileCredentialsProvider.create())
			.build();
	}
	
}
