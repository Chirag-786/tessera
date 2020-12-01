package com.quorum.tessera.key.vault.azure;

import com.azure.core.credential.TokenCredential;
import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.security.keyvault.secrets.SecretClient;
import com.azure.security.keyvault.secrets.SecretClientBuilder;

class AzureSecretClientFactory {

    private final String url;

    private final TokenCredential tokenCredential;

    AzureSecretClientFactory(String url, TokenCredential tokenCredential) {
        this.url = url;
        this.tokenCredential = tokenCredential;
    }

    SecretClient create() {

        return new SecretClientBuilder()
            .vaultUrl(url)
            .httpLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BODY_AND_HEADERS))
            .credential(tokenCredential)
            .buildClient();
    }
}
