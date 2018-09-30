package dg.bin.com.retrofitokhttprxjavatest.model;

/**
 * Created by b on 2018/9/25.
 */

public class TokenModel {
    String code;
    String userId;
    String token;
    String url;
    String errorMessage;


    @Override
    public String toString() {
        return "code"+":"+code+"\n"
                +"userId"+":"+userId+"\n"
                +"token"+":"+token+"\n"
                +"url"+":"+url+"\n"
                +"errorMessage"+":"+errorMessage;
    }
}
