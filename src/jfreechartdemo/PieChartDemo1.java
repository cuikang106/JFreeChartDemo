/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jfreechartdemo;

import java.awt.Dimension;
import java.awt.Font;
import java.util.Locale;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Cui Kang
 */
public class PieChartDemo1 extends ApplicationFrame{

    /**
     * @param args the command line arguments
     */
    
    //构造方法
    public PieChartDemo1(String string){
        super(string);
        JPanel jpanel=createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500,270));//设置jpanel的尺寸
        setContentPane(jpanel); //选择容器？
    }
    
    //封装一个生成数据集的方法，作用是生成一个固定的数据集
    //一般不需要封装这个方法
    public static PieDataset createDataset(){
        DefaultPieDataset defaultPieDataset=new DefaultPieDataset();
        defaultPieDataset.setValue("One", new Double(43.2));
        defaultPieDataset.setValue("Two", new Double(27.2));
        return defaultPieDataset;
    }
    
    //绘图
    private static JFreeChart createChart(PieDataset piedataset){
        JFreeChart jfreechart=ChartFactory.createPieChart("Pie ChartDemo1", 
                piedataset, true, true, Locale.ITALY);
        TextTitle texttitle=jfreechart.getTitle();  //获取图标题的引用
        texttitle.setToolTipText("A title tool tip!");
        PiePlot pieplot=(PiePlot)jfreechart.getPlot();//获取图的Plot类，用于设置字体、颜色等
        pieplot.setLabelFont(new Font("Arial Black",0,20));//标签的字体
        pieplot.setNoDataMessage("No data available");//没有数据时的显示信息
        pieplot.setCircular(false);
        pieplot.setLabelGap(0.02);//标签的间距
        return jfreechart;
    }
    
    public static JPanel createDemoPanel(){
        JFreeChart jfreechart=createChart(createDataset());
        return new ChartPanel(jfreechart);
    }
    
    public static void main(String[] strings){
        PieChartDemo1 piechartdemo1=new PieChartDemo1("这是frame的标题");//参数为frame的标题
        piechartdemo1.pack();//使这个frame的大小适合其内容，即jpanel
        RefineryUtilities.centerFrameOnScreen(piechartdemo1);
        piechartdemo1.setVisible(true);
    }
}
