package com.jzk.commonwms.data.zip;

import java.util.List;

/**
 * $dsc 工位的实体
 * author: timi
 * create at: 2018-07-19 16:50
 */
public class StationBean {

    /**
     * stations : [{"stationName":"注塑工位D","stationCode":"OP101D","productionLineCode":"L-D01"},{"stationName":"注塑工位N","stationCode":"OP101N","productionLineCode":"L-N01"}]
     * items : null
     * mos : null
     * eqpments : null
     * resultMessages : null
     */

    private Object items;
    private Object mos;
    private Object eqpments;
    private Object resultMessages;
    private List<StationsBean> stations;

    public Object getItems() {
        return items;
    }

    public void setItems(Object items) {
        this.items = items;
    }

    public Object getMos() {
        return mos;
    }

    public void setMos(Object mos) {
        this.mos = mos;
    }

    public Object getEqpments() {
        return eqpments;
    }

    public void setEqpments(Object eqpments) {
        this.eqpments = eqpments;
    }

    public Object getResultMessages() {
        return resultMessages;
    }

    public void setResultMessages(Object resultMessages) {
        this.resultMessages = resultMessages;
    }

    public List<StationsBean> getStations() {
        return stations;
    }

    public void setStations(List<StationsBean> stations) {
        this.stations = stations;
    }

    public static class StationsBean {
        /**
         * stationName : 注塑工位D
         * stationCode : OP101D
         * productionLineCode : L-D01
         */

        private String stationName;
        private String stationCode;
        private String productionLineCode;

        public String getStationName() {
            return stationName;
        }

        public void setStationName(String stationName) {
            this.stationName = stationName;
        }

        public String getStationCode() {
            return stationCode;
        }

        public void setStationCode(String stationCode) {
            this.stationCode = stationCode;
        }

        public String getProductionLineCode() {
            return productionLineCode;
        }

        public void setProductionLineCode(String productionLineCode) {
            this.productionLineCode = productionLineCode;
        }

        @Override
        public String toString() {
            return "StationsBean{" +
                    "stationName='" + stationName + '\'' +
                    ", stationCode='" + stationCode + '\'' +
                    ", productionLineCode='" + productionLineCode + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "StationBean{" +
                "items=" + items +
                ", mos=" + mos +
                ", eqpments=" + eqpments +
                ", resultMessages=" + resultMessages +
                ", stations=" + stations +
                '}';
    }
}
