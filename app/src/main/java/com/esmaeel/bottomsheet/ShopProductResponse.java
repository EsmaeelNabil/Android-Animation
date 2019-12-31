package com.esmaeel.bottomsheet;

import java.util.ArrayList;

public class ShopProductResponse {


    /**
     * status : true
     * msg : ["Success Request"]
     * data : {"products":[{"id":1,"product_name":"product1","product_description":"product1 description","main_image":"https://beauty-apps.com/storage/1569151112_79.png","category_id":"1","branches_count":"2","store_name":"Islam","old_price":"200.00","new_price":"150.00","count":"10.00","branch_name":"maimi","store_type":"sub Salon 1","store_logo":"https://beauty-apps.com/storage/salons/1570029484_76.jpg","currency":"EGP"}]}
     */

    private boolean status;
    private DataBean data;
    private ArrayList<String> msg;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public ArrayList<String> getMsg() {
        return msg;
    }

    public void setMsg(ArrayList<String> msg) {
        this.msg = msg;
    }

    public static class DataBean {
        private ArrayList<ProductsBean> products;

        public ArrayList<ProductsBean> getProducts() {
            return products;
        }

        public void setProducts(ArrayList<ProductsBean> products) {
            this.products = products;
        }

        public static class ProductsBean {
            public ProductsBean(String product_name, String product_description, String main_image) {
                this.product_name = product_name;
                this.product_description = product_description;
                this.main_image = main_image;
            }

            /**
             * id : 1
             * product_name : product1
             * product_description : product1 description
             * main_image : https://beauty-apps.com/storage/1569151112_79.png
             * category_id : 1
             * branches_count : 2
             * store_name : Islam
             * old_price : 200.00
             * new_price : 150.00
             * count : 10.00
             * branch_name : maimi
             * store_type : sub Salon 1
             * store_logo : https://beauty-apps.com/storage/salons/1570029484_76.jpg
             * currency : EGP
             */



            private int id;
            private String product_name;
            private String product_description;
            private String main_image;
            private String category_id;
            private String branches_count;
            private String store_name;
            private String sales_price;
            private String count;
            private String branch_name;
            private String store_type;
            private String store_logo;
            private String currency;

            private String product_status;

            public String getProduct_status() {
                return product_status;
            }

            public void setProduct_status(String product_status) {
                this.product_status = product_status;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getProduct_name() {
                return product_name;
            }

            public void setProduct_name(String product_name) {
                this.product_name = product_name;
            }

            public String getProduct_description() {
                return product_description;
            }

            public void setProduct_description(String product_description) {
                this.product_description = product_description;
            }

            public String getMain_image() {
                return main_image;
            }

            public void setMain_image(String main_image) {
                this.main_image = main_image;
            }

            public String getCategory_id() {
                return category_id;
            }

            public void setCategory_id(String category_id) {
                this.category_id = category_id;
            }

            public String getBranches_count() {
                return branches_count;
            }

            public void setBranches_count(String branches_count) {
                this.branches_count = branches_count;
            }

            public String getStore_name() {
                return store_name;
            }

            public void setStore_name(String store_name) {
                this.store_name = store_name;
            }


            public String getSales_price() {
                if (sales_price == null) {
                    return sales_price = "0";
                } else
                    return sales_price;
            }

            public void setSales_price(String sales_price) {
                this.sales_price = sales_price;
            }

            public String getCount() {
                return count;
            }

            public void setCount(String count) {
                this.count = count;
            }

            public String getBranch_name() {
                return branch_name;
            }

            public void setBranch_name(String branch_name) {
                this.branch_name = branch_name;
            }

            public String getStore_type() {
                return store_type;
            }

            public void setStore_type(String store_type) {
                this.store_type = store_type;
            }

            public String getStore_logo() {
                return store_logo;
            }

            public void setStore_logo(String store_logo) {
                this.store_logo = store_logo;
            }

            public String getCurrency() {
                return currency;
            }

            public void setCurrency(String currency) {
                this.currency = currency;
            }
        }
    }
}
