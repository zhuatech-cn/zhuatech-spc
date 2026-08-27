/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.spc.service;
import jakarta.validation.constraints.*;
import org.springframework.stereotype.Service;
import java.util.*;
@Service public class DomainDecisionService {
 public DecisionResult assess(DecisionRequest request) { if(request.usl()<=request.lsl())throw new IllegalArgumentException("规格上限必须大于规格下限");double cp=(request.usl()-request.lsl())/(6*request.sigma());double cpk=Math.min(request.usl()-request.mean(),request.mean()-request.lsl())/(3*request.sigma());int score=(int)Math.round(Math.min(100,Math.max(0,cpk/1.33*100)));List<String> actions=new ArrayList<>();if(cpk<1.33)actions.add("执行过程能力提升计划");if(cpk<1)actions.add("隔离产品并调整过程中心");if(request.ruleViolation()){score-=25;actions.add("调查控制图判异信号");}return result(score,actions,"CAPABLE","IMPROVE","STOP_PROCESS",Map.of("cp",Math.round(cp*1000)/1000d,"cpk",Math.round(cpk*1000)/1000d,"sampleSize",request.sampleSize())); }
 private DecisionResult result(int raw,List<String> actions,String good,String warn,String bad,Map<String,Object> metrics) { int score=Math.max(0,Math.min(100,raw));String decision=score>=80?good:score>=50?warn:bad;return new DecisionResult(decision,score,metrics,List.copyOf(actions)); }
 private DecisionResult riskResult(int raw,List<String> actions,String good,String warn,String bad,Map<String,Object> metrics) { int score=Math.max(0,Math.min(100,raw));String decision=score>=70?bad:score>=40?warn:good;return new DecisionResult(decision,score,metrics,List.copyOf(actions)); }
 public record DecisionRequest(
        @NotBlank String processCode,
        double usl,
        double lsl,
        double mean,
        @Positive double sigma,
        @Min(2) int sampleSize,
        boolean ruleViolation) {}
 public record DecisionResult(String decision,int score,Map<String,Object> metrics,List<String> actions) {}
}
