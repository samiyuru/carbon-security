/*
 * Copyright (c) 2016, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.wso2.carbon.security.caas.user.core.common;

import org.wso2.carbon.security.caas.user.core.config.StoreConfig;
import org.wso2.carbon.security.caas.user.core.exception.AuthorizationStoreException;
import org.wso2.carbon.security.caas.user.core.exception.CredentialStoreException;
import org.wso2.carbon.security.caas.user.core.exception.IdentityStoreException;
import org.wso2.carbon.security.caas.user.core.service.RealmService;
import org.wso2.carbon.security.caas.user.core.store.AuthorizationStore;
import org.wso2.carbon.security.caas.user.core.store.CredentialStore;
import org.wso2.carbon.security.caas.user.core.store.IdentityStore;

/**
 * Basic user realm service.
 */
public class CarbonRealmServiceImpl implements RealmService {

    private CredentialStore credentialStore = new CredentialStore();
    private AuthorizationStore authorizationStore = new AuthorizationStore();
    private IdentityStore identityStore = new IdentityStore();

    public CarbonRealmServiceImpl(StoreConfig storeConfig) throws IdentityStoreException, AuthorizationStoreException,
            CredentialStoreException {

        super();
        credentialStore.init(this, storeConfig.getCredentialStoreConfigMap());
        authorizationStore.init(this, storeConfig.getAuthorizationStoreConfigMap());
        identityStore.init(this, storeConfig.getIdentityStoreConfigMap());
    }

    /**
     * Get the credential store.
     *
     * @return @see CredentialStore
     */
    @Override
    public CredentialStore getCredentialStore() {
        return credentialStore;
    }

    /**
     * Get the authorization store.
     *
     * @return @see AuthorizationStore.
     */
    @Override
    public AuthorizationStore getAuthorizationStore() {
        return authorizationStore;
    }

    /**
     * Get the identity store.
     *
     * @return @see IdentityStore
     */
    @Override
    public IdentityStore getIdentityStore() {
        return identityStore;
    }

}
