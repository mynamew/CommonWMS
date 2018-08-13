package com.jzk.commonwms.data.zip;

import java.util.List;

/**
 * $dsc 工位的实体
 * author: timi
 * create at: 2018-07-19 16:50
 */
public class BaseReturnBean {


    /**
     * result : {"stations":[{"stationName":"注塑工位D","stationCode":"OP101D","productionLineCode":"L-D01"},{"stationName":"注塑工位N","stationCode":"OP101N","productionLineCode":"L-N01"}],"items":null,"mos":null,"eqpments":null,"resultMessages":null}
     * targetUrl : null
     * success : true
     * error : null
     * unAuthorizedRequest : false
     * __abp : true
     */

    private ResultBean result;
    private Object targetUrl;
    private boolean success;
    private Object error;
    private boolean unAuthorizedRequest;
    private boolean __abp;

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public Object getTargetUrl() {
        return targetUrl;
    }

    public void setTargetUrl(Object targetUrl) {
        this.targetUrl = targetUrl;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getError() {
        return error;
    }

    public void setError(Object error) {
        this.error = error;
    }

    public boolean isUnAuthorizedRequest() {
        return unAuthorizedRequest;
    }

    public void setUnAuthorizedRequest(boolean unAuthorizedRequest) {
        this.unAuthorizedRequest = unAuthorizedRequest;
    }

    public boolean is__abp() {
        return __abp;
    }

    public void set__abp(boolean __abp) {
        this.__abp = __abp;
    }

    public static class ResultBean {
        /**
         * stations : [{"stationName":"注塑工位D","stationCode":"OP101D","productionLineCode":"L-D01"},{"stationName":"注塑工位N","stationCode":"OP101N","productionLineCode":"L-N01"}]
         * items : null
         * mos : null
         * eqpments : null
         * resultMessages : null
         */

        private Object items;
        List<MosBean> mos;
        private Object eqpments;
        private Object resultMessages;
        private List<StationsBean> stations;

        public Object getItems() {
            return items;
        }

        public void setItems(Object items) {
            this.items = items;
        }

        public List<MosBean> getMos() {
            return mos;
        }

        public void setMos(List<MosBean> mos) {
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

        public static class MosBean {
            /**
             * moCode : MO20180710001
             * itemCode : 50101010002
             */

            private String moCode;
            private String itemCode;

            public String getMoCode() {
                return moCode;
            }

            public void setMoCode(String moCode) {
                this.moCode = moCode;
            }

            public String getItemCode() {
                return itemCode;
            }

            public void setItemCode(String itemCode) {
                this.itemCode = itemCode;
            }

            @Override
            public String toString() {
                return "MosBean{" +
                        "moCode='" + moCode + '\'' +
                        ", itemCode='" + itemCode + '\'' +
                        '}';
            }
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
    }
}
