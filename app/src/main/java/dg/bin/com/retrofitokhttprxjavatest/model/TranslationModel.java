package dg.bin.com.retrofitokhttprxjavatest.model;

/**
 * Created by b on 2018/9/25.
 */

public class TranslationModel {

    private int status;

    private content content;

    private static class content {
        private String from;
        private String to;
        private String vendor;
        private String out;
        private int errNo;

        @Override
        public String toString() {
            return "from:"+from+"\n"
                    +"to:"+to+"\n"
                    +"vendor:"+vendor+"\n"
                    +"out:"+out+"\n"
                    +"errNo:"+errNo;
        }
    }

    @Override
    public String toString() {
        return "status:"+status+"\n"
                +content.toString();
    }

}
