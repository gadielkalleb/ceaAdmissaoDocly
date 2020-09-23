package br.com.cea.admission.service;

import br.com.cea.admission.request.Request;
import br.com.cea.admission.response.Authentication;

public interface DoclyService {

    Authentication postAuthentication() throws Exception;
    void postUploadDoc(Request req) throws Exception;
}
