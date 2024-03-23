package com.ltz.my_empl.entity;

import java.io.Serializable;

public class EmplInfoCheckResponse implements Serializable {

    /**
     * code : 20000
     * message : 审核结果
     * data : {"id":121,"studentId":"202012345678","companyName":"米哈游","companyType":"省","companyProvince":"湖南省","companyCity":"安徽","signDate":"2024-03-23","postgraduate":"1","emplOntime":"1","emplWithintwo":"1","status":"waiting","ideaComment":null}
     */

    private int code;
    private String message;
    private EmplInfoCheckEntity data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public EmplInfoCheckEntity getData() {
        return data;
    }

    public void setData(EmplInfoCheckEntity data) {
        this.data = data;
    }

    public static class EmplInfoCheckEntity {
        /**
         * id : 121
         * studentId : 202012345678
         * companyName : 米哈游
         * companyType : 省
         * companyProvince : 湖南省
         * companyCity : 安徽
         * signDate : 2024-03-23
         * postgraduate : 1
         * emplOntime : 1
         * emplWithintwo : 1
         * status : waiting
         * ideaComment : null
         */

        private String studentId;
        private String companyName;
        private String companyType;
        private String companyProvince;
        private String companyCity;
        private String signDate;
        private String postgraduate;
        private String emplOntime;
        private String emplWithintwo;
        private String status;
        private String ideaComment;

        public String getStudentId() {
            return studentId;
        }

        public void setStudentId(String studentId) {
            this.studentId = studentId;
        }

        public String getCompanyName() {
            return companyName;
        }

        public void setCompanyName(String companyName) {
            this.companyName = companyName;
        }

        public String getCompanyType() {
            return companyType;
        }

        public void setCompanyType(String companyType) {
            this.companyType = companyType;
        }

        public String getCompanyProvince() {
            return companyProvince;
        }

        public void setCompanyProvince(String companyProvince) {
            this.companyProvince = companyProvince;
        }

        public String getCompanyCity() {
            return companyCity;
        }

        public void setCompanyCity(String companyCity) {
            this.companyCity = companyCity;
        }

        public String getSignDate() {
            return signDate;
        }

        public void setSignDate(String signDate) {
            this.signDate = signDate;
        }

        public String getPostgraduate() {
            return postgraduate;
        }

        public void setPostgraduate(String postgraduate) {
            this.postgraduate = postgraduate;
        }

        public String getEmplOntime() {
            return emplOntime;
        }

        public void setEmplOntime(String emplOntime) {
            this.emplOntime = emplOntime;
        }

        public String getEmplWithintwo() {
            return emplWithintwo;
        }

        public void setEmplWithintwo(String emplWithintwo) {
            this.emplWithintwo = emplWithintwo;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getIdeaComment() {
            return ideaComment;
        }

        public void setIdeaComment(String ideaComment) {
            this.ideaComment = ideaComment;
        }
    }
}
