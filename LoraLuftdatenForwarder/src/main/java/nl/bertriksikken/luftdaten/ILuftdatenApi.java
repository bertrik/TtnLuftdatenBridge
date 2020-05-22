package nl.bertriksikken.luftdaten;

import nl.bertriksikken.luftdaten.dto.LuftdatenMessage;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * REST API for luftdaten.info
 */
public interface ILuftdatenApi {

    /**
     * Uploads sensor measurement data.
     * 
     * @param pin     the PIN, "1" for dust data
     * @param sensor  the sensor name, e.g. "TTN-0004A30B001E00BE"
     * @param message the measurement message
     * @return task to execute the web method
     */
    @POST("/v1/push-sensor-data/")
    Call<String> pushSensorData(@Header("X-Pin") String pin, @Header("X-Sensor") String sensor,
            @Body LuftdatenMessage message);

}
