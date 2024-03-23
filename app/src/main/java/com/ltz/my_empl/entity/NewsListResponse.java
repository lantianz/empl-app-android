package com.ltz.my_empl.entity;

import java.io.Serializable;
import java.util.List;

public class NewsListResponse implements Serializable {

    /**
     * code : 20000
     * msg : 第 1 页的结果
     * page : {"totalPage":11,"pageSize":5,"totalCount":51,"list":[{"id":1,"newsId":"1","title":"测试标题","author":"测试","sendTime":"2024-03-19 01:09","content":"121212"},{"id":2,"newsId":"2","title":"哔哩哔哩链接","author":"秋柏","sendTime":"2024-03-19 01:12","content":"<p>哔哩哔哩打开&nbsp;&nbsp;<\/p><p><a href=\"https://www.bilibili.com/\" target=\"_blank\">https://www.bilibili.com/<\/a><\/p>"},{"id":3,"newsId":"3","title":"新闻8点见丨邯郸13岁遇害少年已尸检；凯特王妃\u201c失踪\u201d疑云","author":"北京市","sendTime":"2024-03-19 16:58","content":"<p><strong>新闻8点见，多一点洞见。每天早晚8点与你准时相约，眺望更大的世界。<\/strong><\/p><p><strong>英国人气最高的凯特王妃\u201c失踪\u201d风波正逐渐演变成悬疑大片。自凯特在公众面前消失80多天以来，英国王室在此事上的沉默，被外界认为是不同寻常的表现。<\/strong><\/p><p>据英国媒体3月18日报道，有目击者称，当地时间3月16日上午，自己在温莎农场商店遇到了前来购物的威廉王子和凯特王妃，凯特当时看上去\u201c愉快与健康\u201d。不过，该报道并未公布凯特现身的有关视频或照片。3月17日，威廉和凯特的官方社交媒体账号发布了一段视频，内容是向英军爱尔兰军团致以\u201c圣帕特里克日\u201d的节日问候，但视频中并未出现凯特的画面。<\/p><p><img src=\"https://q0.itc.cn/q_70/images03/20240318/78f4df284953474c8841df4a80d885b9.jpeg\" width=\"100%\"/><\/p><p>当地时间2023年12月25日，威廉王子和凯特带着孩子出席活动。图/IC<\/p><p>凯特王妃最近一次公开露面是在去年12月25日圣诞节。当天，威廉王子和凯特带着他们的三个孩子乔治王子、夏洛特公主和路易斯王子出现在媒体镜头前，凯特看上去情绪饱满身体健康。此前三天，英国官方还公布了凯特将于2024年初出访意大利的消息，这说明在去年圣诞节前后凯特尚能履行王室职能。然而1月16日，英国王室突然发表官方声明说，凯特王妃正在做计划中的、与癌症无关的腹部手术，由于凯特本人希望对个人医疗信息保密，所以不透露相关细节。<\/p><p>1月29日，肯辛顿宫（英国王室驻地）方面终于发布声明，证实凯特出院。同一天，查尔斯国王也出了院。他与凯特一样，都没有选择英国王室成员通常就诊的爱德华七世医院，而选择了一家位于豪宅区的\u201c伦敦诊所\u201d入院治疗。不同的是，75岁的查尔斯治疗的是不明癌症，仅住了三天院，而42岁的凯特为了\u201c与癌症无关\u201d的一场手术，住了13天院。<\/p><p>凯特3月10日发的母亲节合照被指有十余处P图（对图片进行修改、调整等），3月11日网友拍到了威廉和凯特外出的照片也被认为是拿2016年的照片P的，或许都有此原因。但由此也导致猜疑愈演愈烈。<\/p><p>根据英国王室传统，会发布官方照片庆祝王室孩子们的生日，最近一次将是4月23日路易斯王子生日。如果届时凯特没有出现在照片中或仍被认为是P的，那么凯特\u201c失踪\u201d确有可能引发更大风暴。<\/p><p><strong>3月17日邯郸市肥乡区发布情况通报，近日肥乡区初一学生王某某被杀害。涉案犯罪嫌疑人被全部抓获，现已采取刑事强制措施。司法机关将对犯罪行为依法予以惩处。<\/strong><\/p><p>3月18日，新京报记者从王某某家属了解到，17日24时，邯郸警方法医在肥乡区殡仪馆对其尸体进行了尸检解剖，尸检至18日1时48分结束。<\/p><p><img src=\"https://q0.itc.cn/q_70/images03/20240318/bd4c0597ddd844e290a3e67369007d16.jpeg\" width=\"100%\"/><\/p><p>发现遗体的废弃蔬菜大棚。新京报记者 李英强 摄<\/p><p>家属介绍，尸检前，王某某的父亲对孩子身体进行了查看，发现孩子头部、背部有明显伤痕。目前正在等待尸检鉴定结果。<\/p><p>案发后多个社交平台博主发帖，传播王某某遇害后的颅骨照片，并配文说明\u201c死者被活埋、案件有成年人帮凶\u201d的分析。新京报记者从邯郸权威消息源处证实，上述网传内容属谣言。<\/p>"},{"id":4,"newsId":"4","title":"DrSFwR","author":"琦","sendTime":null,"content":"P1iK9Kj6VIlm9dfH00nHNL3356H3Pj"},{"id":5,"newsId":"5","title":"3JeVST","author":"嘉许","sendTime":null,"content":"uSXStq2NFd1rXrs3W3lp27CkVXSPny"}],"pageNum":1}
     */

    private int code;
    private String msg;
    private PageBean page;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public PageBean getPage() {
        return page;
    }

    public void setPage(PageBean page) {
        this.page = page;
    }

    public static class PageBean {
        /**
         * totalPage : 11
         * pageSize : 5
         * totalCount : 51
         * list : [{"id":1,"newsId":"1","title":"测试标题","author":"测试","sendTime":"2024-03-19 01:09","content":"121212"},{"id":2,"newsId":"2","title":"哔哩哔哩链接","author":"秋柏","sendTime":"2024-03-19 01:12","content":"<p>哔哩哔哩打开&nbsp;&nbsp;<\/p><p><a href=\"https://www.bilibili.com/\" target=\"_blank\">https://www.bilibili.com/<\/a><\/p>"},{"id":3,"newsId":"3","title":"新闻8点见丨邯郸13岁遇害少年已尸检；凯特王妃\u201c失踪\u201d疑云","author":"北京市","sendTime":"2024-03-19 16:58","content":"<p><strong>新闻8点见，多一点洞见。每天早晚8点与你准时相约，眺望更大的世界。<\/strong><\/p><p><strong>英国人气最高的凯特王妃\u201c失踪\u201d风波正逐渐演变成悬疑大片。自凯特在公众面前消失80多天以来，英国王室在此事上的沉默，被外界认为是不同寻常的表现。<\/strong><\/p><p>据英国媒体3月18日报道，有目击者称，当地时间3月16日上午，自己在温莎农场商店遇到了前来购物的威廉王子和凯特王妃，凯特当时看上去\u201c愉快与健康\u201d。不过，该报道并未公布凯特现身的有关视频或照片。3月17日，威廉和凯特的官方社交媒体账号发布了一段视频，内容是向英军爱尔兰军团致以\u201c圣帕特里克日\u201d的节日问候，但视频中并未出现凯特的画面。<\/p><p><img src=\"https://q0.itc.cn/q_70/images03/20240318/78f4df284953474c8841df4a80d885b9.jpeg\" width=\"100%\"/><\/p><p>当地时间2023年12月25日，威廉王子和凯特带着孩子出席活动。图/IC<\/p><p>凯特王妃最近一次公开露面是在去年12月25日圣诞节。当天，威廉王子和凯特带着他们的三个孩子乔治王子、夏洛特公主和路易斯王子出现在媒体镜头前，凯特看上去情绪饱满身体健康。此前三天，英国官方还公布了凯特将于2024年初出访意大利的消息，这说明在去年圣诞节前后凯特尚能履行王室职能。然而1月16日，英国王室突然发表官方声明说，凯特王妃正在做计划中的、与癌症无关的腹部手术，由于凯特本人希望对个人医疗信息保密，所以不透露相关细节。<\/p><p>1月29日，肯辛顿宫（英国王室驻地）方面终于发布声明，证实凯特出院。同一天，查尔斯国王也出了院。他与凯特一样，都没有选择英国王室成员通常就诊的爱德华七世医院，而选择了一家位于豪宅区的\u201c伦敦诊所\u201d入院治疗。不同的是，75岁的查尔斯治疗的是不明癌症，仅住了三天院，而42岁的凯特为了\u201c与癌症无关\u201d的一场手术，住了13天院。<\/p><p>凯特3月10日发的母亲节合照被指有十余处P图（对图片进行修改、调整等），3月11日网友拍到了威廉和凯特外出的照片也被认为是拿2016年的照片P的，或许都有此原因。但由此也导致猜疑愈演愈烈。<\/p><p>根据英国王室传统，会发布官方照片庆祝王室孩子们的生日，最近一次将是4月23日路易斯王子生日。如果届时凯特没有出现在照片中或仍被认为是P的，那么凯特\u201c失踪\u201d确有可能引发更大风暴。<\/p><p><strong>3月17日邯郸市肥乡区发布情况通报，近日肥乡区初一学生王某某被杀害。涉案犯罪嫌疑人被全部抓获，现已采取刑事强制措施。司法机关将对犯罪行为依法予以惩处。<\/strong><\/p><p>3月18日，新京报记者从王某某家属了解到，17日24时，邯郸警方法医在肥乡区殡仪馆对其尸体进行了尸检解剖，尸检至18日1时48分结束。<\/p><p><img src=\"https://q0.itc.cn/q_70/images03/20240318/bd4c0597ddd844e290a3e67369007d16.jpeg\" width=\"100%\"/><\/p><p>发现遗体的废弃蔬菜大棚。新京报记者 李英强 摄<\/p><p>家属介绍，尸检前，王某某的父亲对孩子身体进行了查看，发现孩子头部、背部有明显伤痕。目前正在等待尸检鉴定结果。<\/p><p>案发后多个社交平台博主发帖，传播王某某遇害后的颅骨照片，并配文说明\u201c死者被活埋、案件有成年人帮凶\u201d的分析。新京报记者从邯郸权威消息源处证实，上述网传内容属谣言。<\/p>"},{"id":4,"newsId":"4","title":"DrSFwR","author":"琦","sendTime":null,"content":"P1iK9Kj6VIlm9dfH00nHNL3356H3Pj"},{"id":5,"newsId":"5","title":"3JeVST","author":"嘉许","sendTime":null,"content":"uSXStq2NFd1rXrs3W3lp27CkVXSPny"}]
         * pageNum : 1
         */

        private int totalPage;
        private int pageSize;
        private int totalCount;
        private int pageNum;
        private List<NewsEntity> list;

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getPageNum() {
            return pageNum;
        }

        public void setPageNum(int pageNum) {
            this.pageNum = pageNum;
        }

        public List<NewsEntity> getList() {
            return list;
        }

        public void setList(List<NewsEntity> list) {
            this.list = list;
        }
    }
}
