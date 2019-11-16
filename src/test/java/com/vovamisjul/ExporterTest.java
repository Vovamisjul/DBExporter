package com.vovamisjul;

import org.junit.Test;

import static org.junit.Assert.*;

public class ExporterTest {

    @Test
    public void export() throws Exception {
        var exporter = new Exporter();
        //exporter.export("{\"servicedHouses\":[[{\"city\":\"keeek\",\"street\":\"loool\",\"house\":31},{\"address\":{\"city\":\"keeek\",\"street\":\"loool\",\"house\":31},\"apartments\":{\"1\":{\"number\":1,\"powerConsumption\":0.0,\"hotWaterConsumption\":0.0,\"coldWaterConsumption\":0.0,\"residents\":[{\"name\":\"ivan\",\"gender\":\"MALE\"},{\"name\":\"irina\",\"gender\":\"MALE\"}]}}}],[{\"city\":\"kek\",\"street\":\"lol\",\"house\":312},{\"address\":{\"city\":\"kek\",\"street\":\"lol\",\"house\":312},\"apartments\":{\"4\":{\"number\":4,\"powerConsumption\":0.0,\"hotWaterConsumption\":0.0,\"coldWaterConsumption\":0.0,\"residents\":[]}}}]]}");
    }
}