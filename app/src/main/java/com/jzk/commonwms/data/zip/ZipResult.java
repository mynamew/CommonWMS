package com.jzk.commonwms.data.zip;

import java.util.List;

/**
 * $dsc
 * author: timi
 * create at: 2018-08-13 14:20
 * @author jzk
 */
public class ZipResult {
    private List<BaseReturnBean.ResultBean.StationsBean> stations;
    private List<BaseReturnBean.ResultBean.MosBean> mos;

    public ZipResult() {
    }

    public ZipResult(List<BaseReturnBean.ResultBean.StationsBean> stations, List<BaseReturnBean.ResultBean.MosBean> mos) {
        this.stations = stations;
        this.mos = mos;
    }

    public List<BaseReturnBean.ResultBean.StationsBean> getStations() {
        return stations;
    }

    public void setStations(List<BaseReturnBean.ResultBean.StationsBean> stations) {
        this.stations = stations;
    }

    public List<BaseReturnBean.ResultBean.MosBean> getMos() {
        return mos;
    }

    public void setMos(List<BaseReturnBean.ResultBean.MosBean> mos) {
        this.mos = mos;
    }

    @Override
    public String toString() {
        return "ZipResult{" +
                "stations=" + stations +
                ", mos=" + mos +
                '}';
    }
}
