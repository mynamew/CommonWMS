package com.jzk.commonwms.data;

import java.util.List;

/**
 * 登录的返回
 */

public class LoginBean {


    /**
     * userId : 55
     * fullName : mes
     * currentOrgUnit : {"id":1,"parentId":null,"code":"00000","displayName":"默认组织"}
     * token : p7awP5clD5wzFA4WjdMEENyPG63db4E9lbNi8ilG8FG3GQ6Y7L7znDxlI6HX5pidguQurXqAscgNB9APELUinu1J7xxcVcji9Kd155aD1gD4xsS8jzjzycQUNiEF0_nJ3KaOD8uxg215SvLjcnItKlzEm4CkuygQKsYQ9BpGqOHp2wRxbb3JUO9bX9TKZIihV27yvOOYRg-qm-Ui4M-Sc5M4qHRT18-U70ITMZSi9_p9nkTfVWMdoU4fzDRl5HrF6yC6L12QSHv9eKAsHrqSO25Ivg8IrZwdvexDSk8K9fzVbF-agy_syrWfR6WYxscUlzcgNgi2SgIJMS4gtYvu9g4SAN9SWQymtNyc_jx41pHAOMVqJiOglcAcsGcxIeIRN8-Uf8hwH7t055_IHf4oqaoDtJbQF_AT95-UJuVsrPztOMYWPDFP90VWhd0R_ukID1J5cHW46JEug2B-71AhgIFUH2R8IKqzDjvvZUpU69Y3II1kMaEOBZGCL6Kc027qm76O-r2srDUa6QlGXvFb5FtQSlmSwP3L7NHgLekH9YY
     * grantPermission : {"permissionCode":"Pages","permissionName":"Pages","childPermissions":[{"permissionCode":"Pages.WPDA","permissionName":"WPDA","childPermissions":[{"permissionCode":"Pages.WPDA.InStock","permissionName":"入库作业","childPermissions":[{"permissionCode":"Pages.WPDA.InStock.ReceiveByOrder","permissionName":"采购单收货","childPermissions":null},{"permissionCode":"Pages.WPDA.InStock.ReceiveByDelivery","permissionName":"送货单收货","childPermissions":null},{"permissionCode":"Pages.WPDA.IQC","permissionName":"来料质检","childPermissions":null},{"permissionCode":"Pages.WPDA.BarcodeEdit","permissionName":"无质检条码修改","childPermissions":null},{"permissionCode":"Pages.WPDA.PurInstock","permissionName":"来料入库","childPermissions":null},{"permissionCode":"Pages.WPDA.OtherInstock","permissionName":"其他入库","childPermissions":null}]},{"permissionCode":"Pages.WPDA.OutStock","permissionName":"出库作业","childPermissions":[{"permissionCode":"Pages.WPDA.PurReturn","permissionName":"采购退料","childPermissions":null},{"permissionCode":"Pages.WPDA.WWPick","permissionName":"委外发料","childPermissions":null},{"permissionCode":"Pages.WPDA.WWFeed","permissionName":"委外补料","childPermissions":null},{"permissionCode":"Pages.WPDA.WPDA_WWTransfer","permissionName":"委外调拨","childPermissions":null},{"permissionCode":"Pages.WPDA.PrdPick","permissionName":"生产领料","childPermissions":null},{"permissionCode":"Pages.WPDA.PrdTransfer","permissionName":"生产调拨","childPermissions":null},{"permissionCode":"Pages.WPDA.PrdFeed","permissionName":"生产补料","childPermissions":null},{"permissionCode":"Pages.WPDA.SalesOutStock","permissionName":"销售出库","childPermissions":null},{"permissionCode":"Pages.WPDA.OtherOutStock","permissionName":"其他出库","childPermissions":null}]},{"permissionCode":"Pages.WPDA.StockIn","permissionName":"库内作业","childPermissions":[{"permissionCode":"Pages.WPDA.Transfer","permissionName":"调拨","childPermissions":null},{"permissionCode":"Pages.WPDA.QueryStock","permissionName":"库存查询","childPermissions":null},{"permissionCode":"Pages.WPDA.MatConvert","permissionName":"形态转换","childPermissions":null},{"permissionCode":"Pages.WPDA.StockAdjust","permissionName":"库位调整","childPermissions":null}]},{"permissionCode":"Pages.WPDA.ReportQuery","permissionName":"报表查询","childPermissions":[{"permissionCode":"Pages.WPDA.ReportQuery.StockSummary","permissionName":"报表查询","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.InStockDetailSummary","permissionName":"今日入库明细列表","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.OutStockDetailSummary","permissionName":"今日出库明细列表","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.BarcodeTraces","permissionName":"SN追溯查询","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.BillBarcode","permissionName":"单据条码查询","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.InStockDetail","permissionName":"入库记录查询","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.OutStockDetail","permissionName":"出库记录查询","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.InStockDayStatistics","permissionName":"入库统计","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.OutStockDayStatistics","permissionName":"出库统计","childPermissions":null}]}]}]}
     * orgUnits : [{"id":1,"parentId":null,"code":"00000","displayName":"/  默认组织 "}]
     */

    private int userId;
    private String fullName;
    private CurrentOrgUnitBean currentOrgUnit;
    private String token;
    private GrantPermissionBean grantPermission;
    private List<OrgUnitsBean> orgUnits;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public CurrentOrgUnitBean getCurrentOrgUnit() {
        return currentOrgUnit;
    }

    public void setCurrentOrgUnit(CurrentOrgUnitBean currentOrgUnit) {
        this.currentOrgUnit = currentOrgUnit;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public GrantPermissionBean getGrantPermission() {
        return grantPermission;
    }

    public void setGrantPermission(GrantPermissionBean grantPermission) {
        this.grantPermission = grantPermission;
    }

    public List<OrgUnitsBean> getOrgUnits() {
        return orgUnits;
    }

    public void setOrgUnits(List<OrgUnitsBean> orgUnits) {
        this.orgUnits = orgUnits;
    }

    public static class CurrentOrgUnitBean {
        /**
         * id : 1
         * parentId : null
         * code : 00000
         * displayName : 默认组织
         */

        private int id;
        private Object parentId;
        private String code;
        private String displayName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getParentId() {
            return parentId;
        }

        public void setParentId(Object parentId) {
            this.parentId = parentId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }

        @Override
        public String toString() {
            return "CurrentOrgUnitBean{" +
                    "id=" + id +
                    ", parentId=" + parentId +
                    ", code='" + code + '\'' +
                    ", displayName='" + displayName + '\'' +
                    '}';
        }
    }

    public static class GrantPermissionBean {
        /**
         * permissionCode : Pages
         * permissionName : Pages
         * childPermissions : [{"permissionCode":"Pages.WPDA","permissionName":"WPDA","childPermissions":[{"permissionCode":"Pages.WPDA.InStock","permissionName":"入库作业","childPermissions":[{"permissionCode":"Pages.WPDA.InStock.ReceiveByOrder","permissionName":"采购单收货","childPermissions":null},{"permissionCode":"Pages.WPDA.InStock.ReceiveByDelivery","permissionName":"送货单收货","childPermissions":null},{"permissionCode":"Pages.WPDA.IQC","permissionName":"来料质检","childPermissions":null},{"permissionCode":"Pages.WPDA.BarcodeEdit","permissionName":"无质检条码修改","childPermissions":null},{"permissionCode":"Pages.WPDA.PurInstock","permissionName":"来料入库","childPermissions":null},{"permissionCode":"Pages.WPDA.OtherInstock","permissionName":"其他入库","childPermissions":null}]},{"permissionCode":"Pages.WPDA.OutStock","permissionName":"出库作业","childPermissions":[{"permissionCode":"Pages.WPDA.PurReturn","permissionName":"采购退料","childPermissions":null},{"permissionCode":"Pages.WPDA.WWPick","permissionName":"委外发料","childPermissions":null},{"permissionCode":"Pages.WPDA.WWFeed","permissionName":"委外补料","childPermissions":null},{"permissionCode":"Pages.WPDA.WPDA_WWTransfer","permissionName":"委外调拨","childPermissions":null},{"permissionCode":"Pages.WPDA.PrdPick","permissionName":"生产领料","childPermissions":null},{"permissionCode":"Pages.WPDA.PrdTransfer","permissionName":"生产调拨","childPermissions":null},{"permissionCode":"Pages.WPDA.PrdFeed","permissionName":"生产补料","childPermissions":null},{"permissionCode":"Pages.WPDA.SalesOutStock","permissionName":"销售出库","childPermissions":null},{"permissionCode":"Pages.WPDA.OtherOutStock","permissionName":"其他出库","childPermissions":null}]},{"permissionCode":"Pages.WPDA.StockIn","permissionName":"库内作业","childPermissions":[{"permissionCode":"Pages.WPDA.Transfer","permissionName":"调拨","childPermissions":null},{"permissionCode":"Pages.WPDA.QueryStock","permissionName":"库存查询","childPermissions":null},{"permissionCode":"Pages.WPDA.MatConvert","permissionName":"形态转换","childPermissions":null},{"permissionCode":"Pages.WPDA.StockAdjust","permissionName":"库位调整","childPermissions":null}]},{"permissionCode":"Pages.WPDA.ReportQuery","permissionName":"报表查询","childPermissions":[{"permissionCode":"Pages.WPDA.ReportQuery.StockSummary","permissionName":"报表查询","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.InStockDetailSummary","permissionName":"今日入库明细列表","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.OutStockDetailSummary","permissionName":"今日出库明细列表","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.BarcodeTraces","permissionName":"SN追溯查询","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.BillBarcode","permissionName":"单据条码查询","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.InStockDetail","permissionName":"入库记录查询","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.OutStockDetail","permissionName":"出库记录查询","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.InStockDayStatistics","permissionName":"入库统计","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.OutStockDayStatistics","permissionName":"出库统计","childPermissions":null}]}]}]
         */

        private String permissionCode;
        private String permissionName;
        private List<ChildPermissionsBeanXX> childPermissions;

        public String getPermissionCode() {
            return permissionCode;
        }

        public void setPermissionCode(String permissionCode) {
            this.permissionCode = permissionCode;
        }

        public String getPermissionName() {
            return permissionName;
        }

        public void setPermissionName(String permissionName) {
            this.permissionName = permissionName;
        }

        public List<ChildPermissionsBeanXX> getChildPermissions() {
            return childPermissions;
        }

        public void setChildPermissions(List<ChildPermissionsBeanXX> childPermissions) {
            this.childPermissions = childPermissions;
        }

        public static class ChildPermissionsBeanXX {
            /**
             * permissionCode : Pages.WPDA
             * permissionName : WPDA
             * childPermissions : [{"permissionCode":"Pages.WPDA.InStock","permissionName":"入库作业","childPermissions":[{"permissionCode":"Pages.WPDA.InStock.ReceiveByOrder","permissionName":"采购单收货","childPermissions":null},{"permissionCode":"Pages.WPDA.InStock.ReceiveByDelivery","permissionName":"送货单收货","childPermissions":null},{"permissionCode":"Pages.WPDA.IQC","permissionName":"来料质检","childPermissions":null},{"permissionCode":"Pages.WPDA.BarcodeEdit","permissionName":"无质检条码修改","childPermissions":null},{"permissionCode":"Pages.WPDA.PurInstock","permissionName":"来料入库","childPermissions":null},{"permissionCode":"Pages.WPDA.OtherInstock","permissionName":"其他入库","childPermissions":null}]},{"permissionCode":"Pages.WPDA.OutStock","permissionName":"出库作业","childPermissions":[{"permissionCode":"Pages.WPDA.PurReturn","permissionName":"采购退料","childPermissions":null},{"permissionCode":"Pages.WPDA.WWPick","permissionName":"委外发料","childPermissions":null},{"permissionCode":"Pages.WPDA.WWFeed","permissionName":"委外补料","childPermissions":null},{"permissionCode":"Pages.WPDA.WPDA_WWTransfer","permissionName":"委外调拨","childPermissions":null},{"permissionCode":"Pages.WPDA.PrdPick","permissionName":"生产领料","childPermissions":null},{"permissionCode":"Pages.WPDA.PrdTransfer","permissionName":"生产调拨","childPermissions":null},{"permissionCode":"Pages.WPDA.PrdFeed","permissionName":"生产补料","childPermissions":null},{"permissionCode":"Pages.WPDA.SalesOutStock","permissionName":"销售出库","childPermissions":null},{"permissionCode":"Pages.WPDA.OtherOutStock","permissionName":"其他出库","childPermissions":null}]},{"permissionCode":"Pages.WPDA.StockIn","permissionName":"库内作业","childPermissions":[{"permissionCode":"Pages.WPDA.Transfer","permissionName":"调拨","childPermissions":null},{"permissionCode":"Pages.WPDA.QueryStock","permissionName":"库存查询","childPermissions":null},{"permissionCode":"Pages.WPDA.MatConvert","permissionName":"形态转换","childPermissions":null},{"permissionCode":"Pages.WPDA.StockAdjust","permissionName":"库位调整","childPermissions":null}]},{"permissionCode":"Pages.WPDA.ReportQuery","permissionName":"报表查询","childPermissions":[{"permissionCode":"Pages.WPDA.ReportQuery.StockSummary","permissionName":"报表查询","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.InStockDetailSummary","permissionName":"今日入库明细列表","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.OutStockDetailSummary","permissionName":"今日出库明细列表","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.BarcodeTraces","permissionName":"SN追溯查询","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.BillBarcode","permissionName":"单据条码查询","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.InStockDetail","permissionName":"入库记录查询","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.OutStockDetail","permissionName":"出库记录查询","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.InStockDayStatistics","permissionName":"入库统计","childPermissions":null},{"permissionCode":"Pages.WPDA.ReportQuery.OutStockDayStatistics","permissionName":"出库统计","childPermissions":null}]}]
             */

            private String permissionCode;
            private String permissionName;
            private List<ChildPermissionsBeanX> childPermissions;

            public String getPermissionCode() {
                return permissionCode;
            }

            public void setPermissionCode(String permissionCode) {
                this.permissionCode = permissionCode;
            }

            public String getPermissionName() {
                return permissionName;
            }

            public void setPermissionName(String permissionName) {
                this.permissionName = permissionName;
            }

            public List<ChildPermissionsBeanX> getChildPermissions() {
                return childPermissions;
            }

            public void setChildPermissions(List<ChildPermissionsBeanX> childPermissions) {
                this.childPermissions = childPermissions;
            }

            public static class ChildPermissionsBeanX {
                /**
                 * permissionCode : Pages.WPDA.InStock
                 * permissionName : 入库作业
                 * childPermissions : [{"permissionCode":"Pages.WPDA.InStock.ReceiveByOrder","permissionName":"采购单收货","childPermissions":null},{"permissionCode":"Pages.WPDA.InStock.ReceiveByDelivery","permissionName":"送货单收货","childPermissions":null},{"permissionCode":"Pages.WPDA.IQC","permissionName":"来料质检","childPermissions":null},{"permissionCode":"Pages.WPDA.BarcodeEdit","permissionName":"无质检条码修改","childPermissions":null},{"permissionCode":"Pages.WPDA.PurInstock","permissionName":"来料入库","childPermissions":null},{"permissionCode":"Pages.WPDA.OtherInstock","permissionName":"其他入库","childPermissions":null}]
                 */

                private String permissionCode;
                private String permissionName;
                private List<ChildPermissionsBean> childPermissions;

                public String getPermissionCode() {
                    return permissionCode;
                }

                public void setPermissionCode(String permissionCode) {
                    this.permissionCode = permissionCode;
                }

                public String getPermissionName() {
                    return permissionName;
                }

                public void setPermissionName(String permissionName) {
                    this.permissionName = permissionName;
                }

                public List<ChildPermissionsBean> getChildPermissions() {
                    return childPermissions;
                }

                public void setChildPermissions(List<ChildPermissionsBean> childPermissions) {
                    this.childPermissions = childPermissions;
                }

                public static class ChildPermissionsBean {
                    /**
                     * permissionCode : Pages.WPDA.InStock.ReceiveByOrder
                     * permissionName : 采购单收货
                     * childPermissions : null
                     */

                    private String permissionCode;
                    private String permissionName;
                    private Object childPermissions;

                    public String getPermissionCode() {
                        return permissionCode;
                    }

                    public void setPermissionCode(String permissionCode) {
                        this.permissionCode = permissionCode;
                    }

                    public String getPermissionName() {
                        return permissionName;
                    }

                    public void setPermissionName(String permissionName) {
                        this.permissionName = permissionName;
                    }

                    public Object getChildPermissions() {
                        return childPermissions;
                    }

                    public void setChildPermissions(Object childPermissions) {
                        this.childPermissions = childPermissions;
                    }
                }
            }
        }
    }

    public static class OrgUnitsBean {
        /**
         * id : 1
         * parentId : null
         * code : 00000
         * displayName : /  默认组织
         */

        private int id;
        private Object parentId;
        private String code;
        private String displayName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public Object getParentId() {
            return parentId;
        }

        public void setParentId(Object parentId) {
            this.parentId = parentId;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getDisplayName() {
            return displayName;
        }

        public void setDisplayName(String displayName) {
            this.displayName = displayName;
        }
    }

    @Override
    public String toString() {
        return "LoginBean{" +
                "userId=" + userId +
                ", fullName='" + fullName + '\'' +
                ", currentOrgUnit=" + currentOrgUnit +
                ", token='" + token + '\'' +
                ", grantPermission=" + grantPermission +
                ", orgUnits=" + orgUnits +
                '}';
    }
}
