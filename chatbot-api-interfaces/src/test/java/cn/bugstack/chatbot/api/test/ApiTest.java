package cn.bugstack.chatbot.api.test;

import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class ApiTest {

    @Test
    public void query_unanswered_question() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpGet get = new HttpGet("https://api.zsxq.com/v2/groups/48411118851818/topics?scope=all&count=20");

        get.addHeader("cookie", "zsxq_access_token=4F033D09-8990-0704-8A7F-9812D10276A7_2422F3C83CC59284; zsxqsessionid=4f14594f20f36d590d22d2eb2761c3e5; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22212884881224511%22%2C%22first_id%22%3A%2218b622c3db61878-0f9bfce8e4ade58-26031151-1821369-18b622c3db7137f%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fbugstack.cn%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiNjIyYzNkYjYxODc4LTBmOWJmY2U4ZTRhZGU1OC0yNjAzMTE1MS0xODIxMzY5LTE4YjYyMmMzZGI3MTM3ZiIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjIxMjg4NDg4MTIyNDUxMSJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22212884881224511%22%7D%2C%22%24device_id%22%3A%2218b622c3db61878-0f9bfce8e4ade58-26031151-1821369-18b622c3db7137f%22%7D; abtest_env=product");
        get.addHeader("Content-Type", "application/json;charset=UTF-8");

        CloseableHttpResponse response = httpClient.execute(get);
        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.err.println(res);
        } else {
            System.err.println(response.getStatusLine().getStatusCode());
        }
    }


    @Test
    public void comments() throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();

        HttpPost post = new HttpPost("https://api.zsxq.com/v2/topics/811225185228482/comments");
        post.addHeader("cookie", "zsxq_access_token=4F033D09-8990-0704-8A7F-9812D10276A7_2422F3C83CC59284; zsxqsessionid=4f14594f20f36d590d22d2eb2761c3e5; sensorsdata2015jssdkcross=%7B%22distinct_id%22%3A%22212884881224511%22%2C%22first_id%22%3A%2218b622c3db61878-0f9bfce8e4ade58-26031151-1821369-18b622c3db7137f%22%2C%22props%22%3A%7B%22%24latest_traffic_source_type%22%3A%22%E5%BC%95%E8%8D%90%E6%B5%81%E9%87%8F%22%2C%22%24latest_search_keyword%22%3A%22%E6%9C%AA%E5%8F%96%E5%88%B0%E5%80%BC%22%2C%22%24latest_referrer%22%3A%22https%3A%2F%2Fbugstack.cn%2F%22%7D%2C%22identities%22%3A%22eyIkaWRlbnRpdHlfY29va2llX2lkIjoiMThiNjIyYzNkYjYxODc4LTBmOWJmY2U4ZTRhZGU1OC0yNjAzMTE1MS0xODIxMzY5LTE4YjYyMmMzZGI3MTM3ZiIsIiRpZGVudGl0eV9sb2dpbl9pZCI6IjIxMjg4NDg4MTIyNDUxMSJ9%22%2C%22history_login_id%22%3A%7B%22name%22%3A%22%24identity_login_id%22%2C%22value%22%3A%22212884881224511%22%7D%2C%22%24device_id%22%3A%2218b622c3db61878-0f9bfce8e4ade58-26031151-1821369-18b622c3db7137f%22%7D; abtest_env=product");
        post.addHeader("Content-Type", "application/json;charset=UTF-8");

        String paramJson = "{\n" +
                "  \"req_data\": {\n" +
                "    \"text\": \"你知道吗\\n\",\n" +
                "    \"image_ids\": [],\n" +
                "    \"mentioned_user_ids\": []\n" +
                "  }\n" +
                "}";

        StringEntity stringEntity = new StringEntity(paramJson, ContentType.create("test/json", "UTF-8"));
        post.setEntity(stringEntity);

        CloseableHttpResponse response = httpClient.execute(post);

        if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
            String res = EntityUtils.toString(response.getEntity());
            System.err.println(res);
        } else {
            System.err.println(response.getStatusLine().getStatusCode());
        }
    }
}
