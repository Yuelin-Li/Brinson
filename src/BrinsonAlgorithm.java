import java.util.HashMap;
import java.util.Map;

public class BrinsonAlgorithm {

    public static void main(String[] args) {
        // 准备数据
        Map<String, Double> portfolioWeights = new HashMap<>();
        portfolioWeights.put("Stocks", 0.4);
        portfolioWeights.put("Bonds", 0.3);
        portfolioWeights.put("Cash", 0.3);

        Map<String, Double> benchmarkWeights = new HashMap<>();
        benchmarkWeights.put("Stocks", 0.5);
        benchmarkWeights.put("Bonds", 0.3);
        benchmarkWeights.put("Cash", 0.2);

        Map<String, Double> assetReturns = new HashMap<>();
        assetReturns.put("Stocks", 0.1);
        assetReturns.put("Bonds", 0.05);
        assetReturns.put("Cash", 0.02);

        double benchmarkReturn = 0.07;

        // 计算资产配置效应
        double allocationEffect = calculateAllocationEffect(portfolioWeights, assetReturns);

        // 计算选择效应
        double selectionEffect = calculateSelectionEffect(portfolioWeights, benchmarkWeights, assetReturns);

        // 计算交互效应
        double interactionEffect = benchmarkReturn - allocationEffect - selectionEffect;

        // 输出结果
        System.out.println("Allocation Effect: " + allocationEffect);
        System.out.println("Selection Effect: " + selectionEffect);
        System.out.println("Interaction Effect: " + interactionEffect);
    }

    // 计算资产配置效应
    private static double calculateAllocationEffect(Map<String, Double> portfolioWeights, Map<String, Double> assetReturns) {
        double allocationEffect = 0.0;
        for (String asset : portfolioWeights.keySet()) {
            double weight = portfolioWeights.get(asset);
            double returnRate = assetReturns.get(asset);
            allocationEffect += weight * returnRate;
        }
        return allocationEffect;
    }

    // 计算选择效应
    private static double calculateSelectionEffect(Map<String, Double> portfolioWeights, Map<String, Double> benchmarkWeights, Map<String, Double> assetReturns) {
        double selectionEffect = 0.0;
        for (String asset : portfolioWeights.keySet()) {
            double weightDiff = portfolioWeights.get(asset) - benchmarkWeights.get(asset);
            double returnRate = assetReturns.get(asset);
            selectionEffect += weightDiff * returnRate;
        }
        return selectionEffect;
    }
}
