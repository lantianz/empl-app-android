package com.ltz.my_empl.entity;

import java.io.Serializable;
import java.util.List;

public class StandInfoResponse implements Serializable {

    /**
     * code : 20000
     * message : success!!!
     * data : {"standInfo":{}}
     */

    private int code;
    private String message;
    private DataBean data;

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

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * standInfo : {"company_type":["企业","学校与教育机构","医疗机构","科研机构","金融与保险机构","农林牧渔","公共服务机构","租赁与房地产","贸易与物流","科技与信息技术","建筑与工程","人力资源与咨询","餐饮与旅游","文化与媒体机构"],"province":["北京市","天津市","河北省","河北省","河北省","河北省","河北省","河北省","河北省","河北省","河北省","河北省","河北省","山西省","山西省","山西省","山西省","山西省","山西省","山西省","山西省","山西省","山西省","山西省","内蒙古自治区","内蒙古自治区","内蒙古自治区","内蒙古自治区","内蒙古自治区","内蒙古自治区","内蒙古自治区","内蒙古自治区","内蒙古自治区","内蒙古自治区","内蒙古自治区","内蒙古自治区","辽宁省","辽宁省","辽宁省","辽宁省","辽宁省","辽宁省","辽宁省","辽宁省","辽宁省","辽宁省","辽宁省","辽宁省","辽宁省","辽宁省","吉林省","吉林省","吉林省","吉林省","吉林省","吉林省","吉林省","吉林省","吉林省","黑龙江省","黑龙江省","黑龙江省","黑龙江省","黑龙江省","黑龙江省","黑龙江省","黑龙江省","黑龙江省","黑龙江省","黑龙江省","黑龙江省","黑龙江省","上海市","江苏省","江苏省","江苏省","江苏省","江苏省","江苏省","江苏省","江苏省","江苏省","江苏省","江苏省","江苏省","江苏省","浙江省","浙江省","浙江省","浙江省","浙江省","浙江省","浙江省","浙江省","浙江省","浙江省","浙江省","安徽省","安徽省","安徽省","安徽省","安徽省","安徽省","安徽省","安徽省","安徽省","安徽省","安徽省","安徽省","安徽省","安徽省","安徽省","安徽省","福建省","福建省","福建省","福建省","福建省","福建省","福建省","福建省","福建省","江西省","江西省","江西省","江西省","江西省","江西省","江西省","江西省","江西省","江西省","江西省","山东省","山东省","山东省","山东省","山东省","山东省","山东省","山东省","山东省","山东省","山东省","山东省","山东省","山东省","山东省","山东省","山东省","河南省","河南省","河南省","河南省","河南省","河南省","河南省","河南省","河南省","河南省","河南省","河南省","河南省","河南省","河南省","河南省","河南省","河南省","湖北省","湖北省","湖北省","湖北省","湖北省","湖北省","湖北省","湖北省","湖北省","湖北省","湖北省","湖北省","湖北省","湖北省","湖北省","湖北省","湖北省","湖南省","湖南省","湖南省","湖南省","湖南省","湖南省","湖南省","湖南省","湖南省","湖南省","湖南省","湖南省","湖南省","湖南省","广东省","广东省","广东省","广东省","广东省","广东省","广东省","广东省","广东省","广东省","广东省","广东省","广东省","广东省","广东省","广东省","广东省","广东省","广东省","广东省","广东省","广西壮族自治区","广西壮族自治区","广西壮族自治区","广西壮族自治区","广西壮族自治区","广西壮族自治区","广西壮族自治区","广西壮族自治区","广西壮族自治区","广西壮族自治区","广西壮族自治区","广西壮族自治区","广西壮族自治区","广西壮族自治区","海南省","海南省","海南省","海南省","海南省","海南省","海南省","海南省","海南省","海南省","海南省","海南省","海南省","海南省","海南省","海南省","海南省","海南省","海南省","重庆市","四川省","四川省","四川省","四川省","四川省","四川省","四川省","四川省","四川省","四川省","四川省","四川省","四川省","四川省","四川省","四川省","四川省","四川省","四川省","四川省","四川省","贵州省","贵州省","贵州省","贵州省","贵州省","贵州省","贵州省","贵州省","贵州省","云南省","云南省","云南省","云南省","云南省","云南省","云南省","云南省","云南省","云南省","云南省","云南省","云南省","云南省","云南省","云南省","西藏自治区","西藏自治区","西藏自治区","西藏自治区","西藏自治区","西藏自治区","西藏自治区","陕西省","陕西省","陕西省","陕西省","陕西省","陕西省","陕西省","陕西省","陕西省","陕西省","甘肃省","甘肃省","甘肃省","甘肃省","甘肃省","甘肃省","甘肃省","甘肃省","甘肃省","甘肃省","甘肃省","甘肃省","甘肃省","甘肃省","青海省","青海省","青海省","青海省","青海省","青海省","青海省","青海省","宁夏回族自治区","宁夏回族自治区","宁夏回族自治区","宁夏回族自治区","宁夏回族自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","新疆维吾尔自治区","香港特别行政区","澳门特别行政区","台湾省"],"major":["语言学系","文学系","历史系","哲学系","文化研究中心","数学系","物理系","化学系","生物系","天文系","电气工程系","机械工程系","土木工程系","计算机科学与技术系","软件工程系","大数据系","信息安全系","药学系","公共卫生学院","生物医学工程系","管理学系","企业管理系","会计学系","市场营销系","金融系","法律系","法律实务系","法律研究中心","国际法学院","教育学系","心理学系","教育管理系","教育技术系","成人教育中心","视觉艺术系","表演艺术系","设计系","艺术史与理论系","多媒体艺术中心","新闻学系","广告学系","传播学系","媒体研究中心","社交媒体实验室","农业科学系","农业经济系","农村发展系","兽医学系","农业技术中心","环境科学系","资源管理系","环境工程系","水资源研究中心","可持续发展实验室","心理学系","临床心理学系","心理咨询系","心理测量与评估中心","神经科学研究所","社会学系","人类学系","社会工作系","社会政策研究中心","社会调查中心","国际关系系","国际商务系","国际文化交流系","国际合作中心","外语学习中心","建筑设计系","城市规划系","建筑工程系","建筑技术研究中心","城市设计实验室"],"city":["北京市","天津市","石家庄市","唐山市","邯郸市","秦皇岛市","邢台市","保定市","张家口市","承德市","沧州市","廊坊市","衡水市","太原市","大同市","阳泉市","长治市","晋城市","朔州市","晋中市","运城市","忻州市","临汾市","吕梁市","呼和浩特市","包头市","乌海市","赤峰市","通辽市","鄂尔多斯市","呼伦贝尔市","巴彦淖尔市","乌兰察布市","兴安盟","锡林郭勒盟","阿拉善盟","沈阳市","大连市","鞍山市","抚顺市","本溪市","丹东市","锦州市","营口市","阜新市","辽阳市","盘锦市","铁岭市","朝阳市","葫芦岛市","长春市","吉林市","四平市","辽源市","通化市","白山市","松原市","白城市","延边朝鲜族自治州","哈尔滨市","齐齐哈尔市","鸡西市","鹤岗市","双鸭山市","大庆市","伊春市","佳木斯市","七台河市","牡丹江市","黑河市","绥化市","大兴安岭地区","上海市","南京市","苏州市","无锡市","常州市","镇江市","南通市","泰州市","扬州市","盐城市","连云港市","徐州市","淮安市","宿迁市","杭州市","宁波市","温州市","嘉兴市","湖州市","绍兴市","金华市","衢州市","舟山市","台州市","丽水市","合肥市","芜湖市","蚌埠市","淮南市","马鞍山市","淮北市","铜陵市","安庆市","黄山市","滁州市","阜阳市","宿州市","六安市","亳州市","池州市","宣城市","福州市","厦门市","漳州市","泉州市","三明市","莆田市","南平市","龙岩市","宁德市","南昌市","景德镇市","萍乡市","九江市","新余市","鹰潭市","赣州市","吉安市","宜春市","抚州市","上饶市","济南市","青岛市","淄博市","枣庄市","东营市","烟台市","潍坊市","济宁市","泰安市","威海市","日照市","莱芜市","临沂市","德州市","聊城市","滨州市","菏泽市","郑州市","开封市","洛阳市","平顶山市","安阳市","鹤壁市","新乡市","焦作市","濮阳市","许昌市","漯河市","三门峡市","南阳市","商丘市","信阳市","周口市","驻马店市","济源市","武汉市","黄石市","十堰市","宜昌市","襄阳市","鄂州市","荆门市","孝感市","荆州市","黄冈市","咸宁市","随州市","恩施土家族苗族自治州","仙桃市","潜江市","天门市","神农架林区","长沙市","株洲市","湘潭市","衡阳市","邵阳市","岳阳市","常德市","张家界市","益阳市","郴州市","永州市","怀化市","娄底市","湘西土家族苗族自治州","广州市","深圳市","珠海市","汕头市","韶关市","佛山市","江门市","湛江市","茂名市","肇庆市","惠州市","梅州市","汕尾市","河源市","阳江市","清远市","东莞市","中山市","潮州市","揭阳市","云浮市","南宁市","柳州市","桂林市","梧州市","北海市","防城港市","钦州市","贵港市","玉林市","百色市","贺州市","河池市","来宾市","崇左市","海口市","三亚市","三沙市","儋州市","五指山市","琼海市","文昌市","万宁市","东方市","定安县","屯昌县","澄迈县","临高县","白沙黎族自治县","昌江黎族自治县","乐东黎族自治县","陵水黎族自治县","保亭黎族苗族自治县","琼中黎族苗族自治县","重庆市","成都市","自贡市","攀枝花市","泸州市","德阳市","绵阳市","广元市","遂宁市","内江市","乐山市","南充市","眉山市","宜宾市","广安市","达州市","雅安市","巴中市","资阳市","阿坝藏族羌族自治州","甘孜藏族自治州","凉山彝族自治州","贵阳市","六盘水市","遵义市","安顺市","毕节市","铜仁市","黔西南布依族苗族自治州","黔东南苗族侗族自治州","黔南布依族苗族自治州","昆明市","曲靖市","玉溪市","保山市","昭通市","丽江市","普洱市","临沧市","楚雄彝族自治州","红河哈尼族彝族自治州","文山壮族苗族自治州","西双版纳傣族自治州","大理白族自治州","德宏傣族景颇族自治州","怒江傈僳族自治州","迪庆藏族自治州","拉萨市","日喀则市","昌都市","林芝市","山南市","那曲市","阿里地区","西安市","铜川市","宝鸡市","咸阳市","渭南市","延安市","汉中市","榆林市","安康市","商洛市","兰州市","嘉峪关市","金昌市","白银市","天水市","武威市","张掖市","平凉市","酒泉市","庆阳市","定西市","陇南市","临夏回族自治州","甘南藏族自治州","西宁市","海东市","海北藏族自治州","黄南藏族自治州","海南藏族自治州","果洛藏族自治州","玉树藏族自治州","海西蒙古族藏族自治州","银川市","石嘴山市","吴忠市","固原市","中卫市","乌鲁木齐市","克拉玛依市","吐鲁番市","哈密市","昌吉回族自治州","博尔塔拉蒙古自治州","巴音郭楞蒙古自治州","阿克苏地区","克孜勒苏柯尔克孜自治州","喀什地区","和田地区","伊犁哈萨克自治州","塔城地区","阿勒泰地区","石河子市","阿拉尔市","图木舒克市","五家渠市","北屯市","铁门关市","双河市","可克达拉市","香港特别行政区","澳门特别行政区","台湾省"],"grade":["2018","2019","2020","2021","2022","2023","2024"],"id":["1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43","44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59","60","61","62","63","64","65","66","67","68","69","70","71","72","73","74","75","76","77","78","79","80","81","82","83","84","85","86","87","88","89","90","91","92","93","94","95","96","97","98","99","100","101","102","103","104","105","106","107","108","109","110","111","112","113","114","115","116","117","118","119","120","121","122","123","124","125","126","127","128","129","130","131","132","133","134","135","136","137","138","139","140","141","142","143","144","145","146","147","148","149","150","151","152","153","154","155","156","157","158","159","160","161","162","163","164","165","166","167","168","169","170","171","172","173","174","175","176","177","178","179","180","181","182","183","184","185","186","187","188","189","190","191","192","193","194","195","196","197","198","199","200","201","202","203","204","205","206","207","208","209","210","211","212","213","214","215","216","217","218","219","220","221","222","223","224","225","226","227","228","229","230","231","232","233","234","235","236","237","238","239","240","241","242","243","244","245","246","247","248","249","250","251","252","253","254","255","256","257","258","259","260","261","262","263","264","265","266","267","268","269","270","271","272","273","274","275","276","277","278","279","280","281","282","283","284","285","286","287","288","289","290","291","292","293","294","295","296","297","298","299","300","301","302","303","304","305","306","307","308","309","310","311","312","313","314","315","316","317","318","319","320","321","322","323","324","325","326","327","328","329","330","331","332","333","334","335","336","337","338","339","340","341","342","343","344","345","346","347","348","349","350","351","352","353","354","355","356","357","358","359","360","361","362","363","364","365","366","367","368","369"],"department":["文学院","文学院","文学院","文学院","文学院","理学院","理学院","理学院","理学院","理学院","电气与机械工程学院","电气与机械工程学院","土木工程学院","计算机科学与工程学院","计算机科学与工程学院","计算机科学与工程学院","计算机科学与工程学院","医学院","医学院","医学院","管理学院","管理学院","管理学院","管理学院","管理学院","法学院","法学院","法学院","法学院","教育学院","教育学院","教育学院","教育学院","教育学院","艺术与设计学院","艺术与设计学院","艺术与设计学院","艺术与设计学院","艺术与设计学院","传媒与传播学院","传媒与传播学院","传媒与传播学院","传媒与传播学院","传媒与传播学院","农学院","农学院","农学院","农学院","农学院","环境与资源学院","环境与资源学院","环境与资源学院","环境与资源学院","环境与资源学院","心理学院","心理学院","心理学院","心理学院","心理学院","社会学院","社会学院","社会学院","社会学院","社会学院","国际学院","国际学院","国际学院","国际学院","国际学院","建筑与规划学院","建筑与规划学院","建筑与规划学院","建筑与规划学院","建筑与规划学院"]}
         */

        private StandInfoEntity standInfo;

        public StandInfoEntity getStandInfo() {
            return standInfo;
        }

        public void setStandInfo(StandInfoEntity standInfo) {
            this.standInfo = standInfo;
        }

        public static class StandInfoEntity {
            private List<String> company_type;
            private List<String> province;
            private List<String> major;
            private List<String> city;
            private List<String> grade;
            private List<String> id;
            private List<String> department;

            public List<String> getCompany_type() {
                return company_type;
            }

            public void setCompany_type(List<String> company_type) {
                this.company_type = company_type;
            }

            public List<String> getProvince() {
                return province;
            }

            public void setProvince(List<String> province) {
                this.province = province;
            }

            public List<String> getMajor() {
                return major;
            }

            public void setMajor(List<String> major) {
                this.major = major;
            }

            public List<String> getCity() {
                return city;
            }

            public void setCity(List<String> city) {
                this.city = city;
            }

            public List<String> getGrade() {
                return grade;
            }

            public void setGrade(List<String> grade) {
                this.grade = grade;
            }

            public List<String> getId() {
                return id;
            }

            public void setId(List<String> id) {
                this.id = id;
            }

            public List<String> getDepartment() {
                return department;
            }

            public void setDepartment(List<String> department) {
                this.department = department;
            }
        }
    }
}
