/*
 * Copyright 2019-2023 VMware, Inc.
 * SPDX-License-Identifier: EPL-2.0
 */
package com.vmware.vip.i18n.api.v1.translation;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vmware.vip.api.rest.API;
import com.vmware.vip.api.rest.APIOperation;
import com.vmware.vip.api.rest.APIParamName;
import com.vmware.vip.api.rest.APIV1;
import com.vmware.vip.common.i18n.dto.UpdateTranslationDTO;
import com.vmware.vip.common.i18n.dto.response.APIResponseDTO;
import com.vmware.vip.i18n.api.base.TranslationSyncAction;

/**
 *
 * Provide RESTful API to synchronize the latest translation.
 *
 */
@RestController
public class TranslationSyncAPI extends TranslationSyncAction {
	
	/**
	 * Synchronize the latest translation from GRM or other third party.
	 * <p>
	 * Apply to On-Premise and SaaS.
	 *
	 */
	@Operation(summary = APIOperation.TRANSLATION_UPDATE_VALUE, description = APIOperation.TRANSLATION_UPDATE_NOTES)
	@RequestMapping(value = APIV1.PRODUCT_VERSION, method = RequestMethod.PUT, produces = { API.API_CHARSET })
	@ResponseStatus(HttpStatus.OK)
	public APIResponseDTO updateTranslation(
			@PathVariable(APIParamName.PRODUCT_NAME) String productName,
			@PathVariable(APIParamName.VERSION) String version,
			@RequestBody UpdateTranslationDTO translationData,
			HttpServletRequest request)
			throws Exception {
		return super.updateTranslation(translationData, productName, version, request);
	}

}
