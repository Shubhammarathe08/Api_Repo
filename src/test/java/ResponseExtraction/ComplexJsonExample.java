package ResponseExtraction;

import io.restassured.path.json.JsonPath;

import java.io.File;
import java.util.List;

public class ComplexJsonExample {

    // "$" , "[0]" , "." if key name is there
    // getString("jsonPath")
    //js.getList("jsonPath"). size() | List<> li = js.getList("jsonPath")
    //String s = getString("find({it.key==value}.key)") -- single value
    //List<> li =  getList("findAll({it.key==value}.key)") -- List value


    public static void main(String[] args){
        String complex_json = "[\n" +
                "  {\n" +
                "    \"id\": 7430988,\n" +
                "    \"name\": \"Aanand Iyer\",\n" +
                "    \"email\": \"aanand_iyer@wilkinson-roob.example\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"status\": \"active\",\n" +
                "    \"city\":\"bhopal\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7430987,\n" +
                "    \"name\": \"Ekaling Malik\",\n" +
                "    \"email\": \"ekaling_malik@white.test\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"status\": \"active\",\n" +
                "    \"city\":\"delhi\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7430986,\n" +
                "    \"name\": \"Kalinda Khatri\",\n" +
                "    \"email\": \"kalinda_khatri@cruickshank.test\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\",\n" +
                "    \"city\":\"kolkata\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"firstname\":\"rajesh\",\n" +
                "     \"is_alive\":true,\n" +
                "    \"addresses\":[\n" +
                "      {  \n" +
                "        \"state\":\"maharsahtra\",\n" +
                "        \"city\":\"pune\"\n" +
                "      },\n" +
                "      {\n" +
                "                \"state\":\"madhya pardesh\",\n" +
                "        \"city\":\"pune\"\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  {\n" +
                "    \"firstname\":\"suresh\",\n" +
                "     \"is_alive\":false,\n" +
                "    \"addresses\":[\n" +
                "      {  \n" +
                "        \"state\":\"andhra\",\n" +
                "        \"city\":\"hydrabad\"\n" +
                "      },\n" +
                "      {\n" +
                "                \"state\":\"kerala\",\n" +
                "        \"city\":\"punnu\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "\n" +
                "  \n" +
                "]";

        JsonPath js = new JsonPath(complex_json);
        System.out.println(js.getString("$"));
        System.out.println(js.getString("[0]"));
        System.out.println(js.getString("[0].id"));

        System.out.println(js.getList("$").size());

        System.out.println(js.getString("[3].addresses[1].city"));

        List<String> city_list = js.getList("[3].addresses.city");
        System.out.println(city_list);

        List<String> city_lists = js.getList("addresses.city");
        System.out.println(city_lists);

        List<String> all_city = js.getList("city");
        System.out.println(all_city);


        String complex_json_1 = "[\n" +
                "  {\n" +
                "    \"id\": 7430716,\n" +
                "    \"name\": \"Gudakesa Menon\",\n" +
                "    \"email\": \"menon_gudakesa@kohler.example\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7430715,\n" +
                "    \"name\": \"Girja Malik\",\n" +
                "    \"email\": \"girja_malik@monahan.example\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"status\": \"active\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7430714,\n" +
                "    \"name\": \"Dharmaketu Gandhi\",\n" +
                "    \"email\": \"gandhi_dharmaketu@hermiston-fay.example\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"status\": \"inactive\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7430713,\n" +
                "    \"name\": \"Meghnad Sethi\",\n" +
                "    \"email\": \"meghnad_sethi@halvorson.test\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"status\": \"inactive\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7430711,\n" +
                "    \"name\": \"Bhaumik Bhat\",\n" +
                "    \"email\": \"bhaumik_bhat@gusikowski.test\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"status\": \"inactive\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7430710,\n" +
                "    \"name\": \"Ms. Kailash Iyengar\",\n" +
                "    \"email\": \"kailash_ms_iyengar@fritsch.test\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7430709,\n" +
                "    \"name\": \"Krishna Varman\",\n" +
                "    \"email\": \"krishna_varman@cormier-schowalter.example\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"status\": \"active\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7430707,\n" +
                "    \"name\": \"Prof. Bhaanumati Deshpande\",\n" +
                "    \"email\": \"deshpande_prof_bhaanumati@labadie-swaniawski.test\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"inactive\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7430706,\n" +
                "    \"name\": \"Krishnadas Prajapat\",\n" +
                "    \"email\": \"prajapat_krishnadas@weber.example\",\n" +
                "    \"gender\": \"female\",\n" +
                "    \"status\": \"active\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"id\": 7430705,\n" +
                "    \"name\": \"Rev. Yoginder Kapoor\",\n" +
                "    \"email\": \"yoginder_rev_kapoor@stroman-little.test\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "  }\n" +
                "]";

        String file_path = "C:\\Users\\Lenovo\\Java_Projects\\Api_Automation\\TestData\\Complex_Json_People.json";
        File f = new File(file_path);
        JsonPath js_1 = new JsonPath(f);

        System.out.println(js_1.getString("$"));

        int size = js_1.getList("$").size();
        System.out.println(size);

        List<Integer> li_1 = js_1.getList("id");
        System.out.println(li_1);

        for(int i=0; i<5; i++){
            System.out.println(li_1.get(i));
        }

        List<String> li_2 = js_1.getList("name");
        System.out.println(li_2);

        for(int i=0; i<5; i++){
            System.out.println(li_2.get(i));
        }

        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////");

        //find findAll

        System.out.println(js_1.getString("find{it.name=='Meghnad Sethi'}"));
        System.out.println(js_1.getString("find{it.name=='Meghnad Sethi'}.email"));

       List<Integer> active_ids = js_1.getList("findAll{it.status=='active'}.id");
       System.out.println(active_ids);

        List<String> active_female_names =
                js_1.getList("findAll{it.status=='active' & it.gender=='female'}.name");
        System.out.println(active_female_names);

        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////");


       // and . or
        List<String> active_female_names_obj =
                js_1.getList("findAll{it.status=='active' & it.gender=='female'}");
        System.out.println(active_female_names_obj);

        List<String> male_or_active =
                js_1.getList("findAll{it.status=='active' | it.gender=='male'}");
        System.out.println(male_or_active);

        //filtering  > , < , == , !=
        List<String> id_2_5 =
                js_1.getList("findAll{it.id >1 & it.id<=5}.name");
        System.out.println(id_2_5);

        System.out.println("///////////////////////////////////////////////////////////////////////////////////////////////////");

        String file_path1 = "C:\\Users\\Lenovo\\Java_Projects\\Api_Automation\\TestData\\Complex_Json_People_and_Address.json";
        File f1 = new File(file_path1);
        JsonPath js_2 = new JsonPath(f1);

        System.out.println(js_2.getString("$"));
        System.out.println(js_2.getString("data"));

        System.out.println(js_2.getString("data"));

        List<Integer> data_ids = js_2.getList("data.id");
        System.out.println(data_ids);

        List<Integer> data_cities = js_2.getList("data.city");
        System.out.println(data_cities);

        System.out.println(js_2.getString("data[3]"));

        List<String> address_cities =
                js_2.getList("data[3].addresses.city");
        System.out.println(address_cities);

        List<String> address_cities1 =
                js_2.getList("data.addresses.city");
        System.out.println(address_cities1);




    }
}
