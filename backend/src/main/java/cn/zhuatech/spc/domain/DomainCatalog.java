/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.spc.domain;
import org.springframework.stereotype.Component;
import java.util.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@Component
public class DomainCatalog {
    private final Map<String, WorkflowAction> actions = new LinkedHashMap<>();
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public DomainCatalog() {
        actions.put("ANALYZE", new WorkflowAction("ANALYZE", "执行统计分析", List.of("草稿"), "待处置", "OPERATOR"));
        actions.put("CORRECT", new WorkflowAction("CORRECT", "确认纠正措施", List.of("待处置"), "验证中", "ADMIN"));
        actions.put("CLOSE", new WorkflowAction("CLOSE", "验证关闭", List.of("验证中"), "已稳定", "ADMIN"));
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String systemName() { return "知华科技统计过程控制系统"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String scene() { return "特性、采样、控制图、规则判异、过程能力、异常、纠正措施与分析"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String initialStatus() { return "草稿"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String partyLabel() { return "工序/质量特性"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String amountLabel() { return "质量损失"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String quantityLabel() { return "样本数量"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public String dueLabel() { return "处置期限"; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public List<ModuleDefinition> modules() { return List.of(
            new ModuleDefinition("CHARACTERISTIC", "质量特性", "管理规格、单位、抽样和控制方法"),
            new ModuleDefinition("SAMPLING_PLAN", "抽样计划", "配置频次、样本量和分层规则"),
            new ModuleDefinition("DATA_COLLECTION", "数据采集", "接收人工、设备和检测系统测量值"),
            new ModuleDefinition("CONTROL_CHART", "控制图", "支持计量与计数型控制图"),
            new ModuleDefinition("RULE_ENGINE", "判异规则", "执行越界、趋势、偏移和连串规则"),
            new ModuleDefinition("CAPABILITY", "过程能力", "计算Cp、Cpk、Pp、Ppk及分布"),
            new ModuleDefinition("ALERT", "异常预警", "通知责任人并限制异常过程放行"),
            new ModuleDefinition("CAPA", "纠正措施", "记录原因、措施、验证和关闭"),
            new ModuleDefinition("ANALYTICS", "质量分析", "按产品、设备、班组和期间分析")
        ); }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public Map<String, WorkflowAction> actions() { return Collections.unmodifiableMap(actions); }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record ModuleDefinition(String code,String name,String description) {}
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public record WorkflowAction(String code,String label,List<String> from,String to,String requiredRole) {}
}
