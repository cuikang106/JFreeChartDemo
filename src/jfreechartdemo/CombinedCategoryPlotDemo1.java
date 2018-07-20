/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfreechartdemo;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import static jfreechartdemo.PieChartDemo1.createDemoPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author njau_
 */
public class CombinedCategoryPlotDemo1 extends ApplicationFrame{
    public CombinedCategoryPlotDemo1(String string){
        super(string);
        JPanel jpanel=createDemoPanel();
        jpanel.setPreferredSize(new Dimension(800,600));//设置jpanel的尺寸
        setContentPane(jpanel);
    }
    
    //创建柱形图数据集
    public static CategoryDataset createDataset1(){
        DefaultCategoryDataset defaultcategorydataset1 = new DefaultCategoryDataset();
        defaultcategorydataset1.addValue(10,"合格","2018-7-20");
        defaultcategorydataset1.addValue(1,"不合格","2018-7-20");
        defaultcategorydataset1.addValue(12,"合格","2018-7-21");
        defaultcategorydataset1.addValue(2,"不合格","2018-7-21");
        return defaultcategorydataset1;
    }
    
    //创建折线图数据集
    public static CategoryDataset createDataset2(){
        DefaultCategoryDataset defaultcategorydataset2 = new DefaultCategoryDataset();
        defaultcategorydataset2.addValue(10.0/11,"合格率","2018-7-20");
        defaultcategorydataset2.addValue(12.0/14,"合格率","2018-7-21");
        return defaultcategorydataset2;
    }
    
    public static JFreeChart createchart(){
        //生成CategoryPlot实例
        CategoryDataset dataset1 = createDataset1();
        NumberAxis rangeAxis1 = new NumberAxis("件数");
        rangeAxis1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer renderer1 = new BarRenderer();
        renderer1.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        CategoryPlot subplot1 = new CategoryPlot(dataset1, null, rangeAxis1, renderer1);
        subplot1.setDomainGridlinesVisible(true);
        
        CategoryDataset dataset2 = createDataset2();
        NumberAxis rangeAxis2 = new NumberAxis("合格率");
        rangeAxis2.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer renderer2 = new LineAndShapeRenderer();
        renderer2.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        CategoryPlot subplot2 = new CategoryPlot(dataset2, null, rangeAxis2, renderer2);
        subplot2.setDomainGridlinesVisible(true);
 
        CategoryAxis domainAxis = new CategoryAxis("Category");
        CombinedDomainCategoryPlot plot = new CombinedDomainCategoryPlot(domainAxis);
        plot.add(subplot1, 2);
        plot.add(subplot2, 1);
        JFreeChart result = new JFreeChart(
            "Combined Domain Category Plot Demo",
            new Font("SansSerif", Font.BOLD, 12),
            plot,
            true
            );
        
        return result;
    }
    
    public static JPanel createDemoPanel(){
        JFreeChart jfreechart=createchart();
        return new ChartPanel(jfreechart);
    }
    
    public static void main(String[] strings){
        CombinedCategoryPlotDemo1 demo = new CombinedCategoryPlotDemo1("一个组合图表");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);
    }
}   
