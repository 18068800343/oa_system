package Test;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.ldxx.bean.FlowNode;
import org.ldxx.mapper.FlowNodeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@ContextConfiguration(locations = { "classpath:spring.xml" })
public class TestUtil {

   
	@Autowired
	FlowNodeMapper mapper;
    
    @Test
    public void ruku() {
        // 分页查询
        // 获取 映射 借口 对象 ;
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml"); 
    	mapper = ctx.getBean(FlowNodeMapper.class);
    }
    
    @Test
    public FlowNode updateFcContent() {
        // 分页查询
        // 获取 映射 借口 对象 ;
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml"); 
    	FlowNode fcContent = new FlowNode();
    	mapper = ctx.getBean(FlowNodeMapper.class);
    	//List<FcContent> fcContents = new ArrayList<>();
    	fcContent = mapper.selectStartFlowNode("1");
    	System.out.println(fcContent);
		return fcContent;
    }
    
    
    @Test
    public void test1(){
    	JSONArray array = new JSONArray();
		JSONObject object2 = new JSONObject();
		object2.put("FC_CENGNO","8");
		object2.put("FC_GENO","1");
		object2.put("FC_CODE","1800");
		array.add(object2);
		System.out.println(array.toString());
    }
    public static void main(String[] args) {
    	new TestUtil().updateFcContent();
    	//new TestUtil().test1();
    	System.out.println("我是世界第一zhaowei");
	}
    
}
