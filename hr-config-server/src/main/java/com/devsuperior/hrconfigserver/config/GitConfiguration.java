package com.devsuperior.hrconfigserver.config;

import org.eclipse.jgit.api.TransportConfigCallback;
import org.eclipse.jgit.transport.CredentialItem;
import org.eclipse.jgit.transport.CredentialsProvider;
import org.eclipse.jgit.transport.URIish;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GitConfiguration {

    @Value("${GITHUB_TOKEN}")
    private String githubToken;

    @Bean
    public TransportConfigCallback transportConfigCallback() {
        return transport -> {
            if (transport instanceof org.eclipse.jgit.transport.TransportHttp) {
                ((org.eclipse.jgit.transport.TransportHttp) transport)
                        .setCredentialsProvider(new CredentialsProvider() {
                            @Override
                            public boolean isInteractive() {
                                return false;
                            }

                            @Override
                            public boolean supports(CredentialItem... items) {
                                for (CredentialItem item : items) {
                                    if (item instanceof CredentialItem.StringType
                                            || item instanceof CredentialItem.Password) {
                                        return true;
                                    }
                                }
                                return false;
                            }

                            @Override
                            public boolean get(URIish uri, CredentialItem... items) {
                                for (CredentialItem item : items) {
                                    if (item instanceof CredentialItem.StringType) {
                                        ((CredentialItem.StringType) item).setValue(githubToken);
                                    } else if (item instanceof CredentialItem.Password) {
                                        ((CredentialItem.Password) item).setValue(githubToken.toCharArray());
                                    }
                                }
                                return true;
                            }
                        });
            }
        };
    }
}
