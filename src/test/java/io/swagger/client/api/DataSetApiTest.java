/*
 * DealersAndVehicles
 * No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 * OpenAPI spec version: v1
 * 
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.api.DataSetApi;
import io.swagger.client.model.Answer;
import io.swagger.client.model.AnswerResponse;
import io.swagger.client.model.DatasetIdResponse;
import org.junit.Test;
import org.junit.Ignore;

/**
 * API tests for DataSetApi
 */
@Ignore
public class DataSetApiTest {

    private final DataSetApi api = new DataSetApi();

    
    /**
     * Get correct answer for dataset (cheat)
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void dataSetGetCheatTest() throws ApiException {
        String datasetId = null;
        Answer response = api.dataSetGetCheat(datasetId);

        // TODO: test validations
    }
    
    /**
     * Creates new dataset and returns its ID
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void dataSetGetDataSetIdTest() throws ApiException {
        DatasetIdResponse response = api.dataSetGetDataSetId();

        // TODO: test validations
    }
    
    /**
     * Submit answer for dataset
     *
     * 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void dataSetPostAnswerTest() throws ApiException {
        String datasetId = null;
        Answer answer = null;
        AnswerResponse response = api.dataSetPostAnswer(datasetId, answer);

        // TODO: test validations
    }
    
}
