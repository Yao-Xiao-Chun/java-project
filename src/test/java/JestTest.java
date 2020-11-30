import com.company.project.model.entity.User;
import io.searchbox.client.JestClient;

import io.searchbox.client.JestClientFactory;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.DocumentResult;
import io.searchbox.core.Index;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;

public class JestTest {



    @Value("${spring.data.elasticsearch.cluster-nodes}")
    private String elkAddress;
    /**
     * 测试创建索引
     * @throws IOException
     */
    @Test
    public void createIndex() throws IOException
    {
        User user = new User();
        user.setId((long) 20);
        user.setNickName("铁屑剑豪王大锤12");
        user.setPassword("2345678jhgfdsdfg");
        user.setSex(1);

        Index index = new Index.Builder(user).index("book").type("qihuan").build();

        JestClient jestClient = getJestCline();

        try{
            DocumentResult jr = jestClient.execute(index);
            System.out.println(jr.isSucceeded());
            System.out.println(jr.getId());
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public io.searchbox.client.JestClient getJestCline()
    {
        JestClientFactory jestClientFactory = new JestClientFactory();
        System.out.print("请求地址:"+"");
        jestClientFactory.setHttpClientConfig(new HttpClientConfig.Builder("")
                .multiThreaded(true)
                .build());

        return jestClientFactory.getObject();
    }

}

