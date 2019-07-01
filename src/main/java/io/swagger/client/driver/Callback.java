package io.swagger.client.driver;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import io.swagger.client.ApiException;
import io.swagger.client.api.DataSetApi;
import io.swagger.client.api.DealersApi;
import io.swagger.client.api.VehiclesApi;
import io.swagger.client.model.Answer;
import io.swagger.client.model.DealerAnswer;
import io.swagger.client.model.VehicleAnswer;

public class Callback {
	
	final static int SUCCESS_CODE = 200;
	
	public static String dataSetID;
	
	public static String getDataSetID() {
		return dataSetID;
	}

	public static void setDataSetID(String dataSetID) {
		Callback.dataSetID = dataSetID;
	}
	
	public static List<DealerAnswer> dealers;
	
	public static List<DealerAnswer> getDealers() {
		return dealers;
	}

	public static void setDealers(List<DealerAnswer> dealers) {
		Callback.dealers = dealers;
	}

	public static List<Integer> VehicleIds;
	
	public static List<Integer> getVehicleIDs() {
		return VehicleIds;
	}

	public static void setVehicleIDs(List<Integer> vehicleIds) {
		Callback.VehicleIds=vehicleIds;
	}
	
	public static ConcurrentHashMap<Integer,List<VehicleAnswer>> map;
	
	public static ConcurrentHashMap<Integer, List<VehicleAnswer>> getMap() {
		return map;
	}

	public static void setMap(ConcurrentHashMap<Integer, List<VehicleAnswer>> map) {
		Callback.map = map;
	}
	
	public static DataSetApi dataSetApi;
	
	public static DataSetApi getDataSetApiInstance() {
		if(dataSetApi==null)
			return new DataSetApi();
		return dataSetApi;
	}

	public static void setDataSetApi(DataSetApi dataSetApi) {
		Callback.dataSetApi = dataSetApi;
	}

	public static VehiclesApi vehcilesApi;
	
    public static VehiclesApi getVehcilesApiInstance() {
		if(vehcilesApi==null)
			return new VehiclesApi();
    	return vehcilesApi;
	}

	public static void setVehcilesApi(VehiclesApi vehcilesApi) {
		Callback.vehcilesApi = vehcilesApi;
	}

	public static DealersApi dealertApi;
	
	public static DealersApi getDealertApiInstance() {
		if(dealertApi==null)
			return new DealersApi();
		return dealertApi;
	}

	public static void setDealertApi(DealersApi dealertApi) {
		Callback.dealertApi = dealertApi;
	}
	
	public static void main(String[] args) throws Exception {
		Callback.setDataSetID(Callback.getDataSetApiInstance().dataSetGetDataSetId().getDatasetId()); 
   	    Callback.getVehcilesApiInstance().vehiclesGetIdsAsync(Callback.getDataSetID(), new VehicleIdsCallback());
	}
	
	public static void PostAnswer(List<DealerAnswer> dealers) throws ApiException {
		Answer ans=new Answer();
		ans.setDealers(dealers);
		System.out.println(Callback.getDataSetApiInstance().dataSetPostAnswer(Callback.getDataSetID(), ans));
		System.exit(1);
	}
		
}
