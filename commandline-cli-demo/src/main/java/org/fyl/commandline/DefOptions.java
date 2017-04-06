package org.fyl.commandline;

import org.apache.commons.cli.*;

/**
 * Program arguments: -h -s 10.1.54.121:9876,10.1.54.121:9876 -v=101010
 *
 * @author yiling.feng
 *
 */

public class DefOptions {

    public static void main(String[] args) throws ParseException {

        // 1. CLI定义阶段
        // 方式一：使用构造函数
        Options options = new Options();

                        //短选项 长选项 是否带参 描述
        options.addOption("h", "help", false, "print help");
        options.addOption("s", true, "Sets the servers");

        // 方式二：使用工厂方法
        Option option = Option.builder("v").longOpt("value")
                .argName("property=value").numberOfArgs(2).desc("Sets the values")
                .build();

        options.addOption(option);

        // 2. CLI解析阶段
        CommandLineParser cmdParser = new DefaultParser();
                                        //选项 参数 是否忽略无法解析的选项
        CommandLine cmd = cmdParser.parse(options, args, true);

        if (cmd.hasOption("s")) {
            //3. CLI询问阶段
            String servers = cmd.getOptionValue("s");
            //逻辑处理
            System.out.println(servers);
        }

        if (cmd.hasOption("h")) {
            HelpFormatter helpFormatter = new HelpFormatter();
            helpFormatter.printHelp("hello", options, true);
        }

        if (cmd.hasOption("v")) {
            //逻辑处理
            String v = cmd.getOptionValue("v");
            System.out.println(v);
        }
    }
}
