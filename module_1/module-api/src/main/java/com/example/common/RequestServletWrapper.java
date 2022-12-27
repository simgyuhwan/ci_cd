package com.example.common;

import jakarta.servlet.ReadListener;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

/**
 * RequestServletWrapper.java
 * Class 설명을 작성하세요.
 *
 * @author sgh
 * @since 2022.12.27
 */
public class RequestServletWrapper extends HttpServletRequestWrapper {

    private String requestData = null;


    /**
     * Constructs a request object wrapping the given request.
     *
     * @param request The request to wrap
     * @throws IllegalArgumentException if the request is null
     */
    public RequestServletWrapper(HttpServletRequest request) throws IOException {
        super(request);

        try(Scanner s = new Scanner(request.getInputStream()).useDelimiter("\\A")){
            requestData = s.hasNext() ? s.next() : "";
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        StringReader reader = new StringReader(requestData);

        return new ServletInputStream() {
            private ReadListener readListener = null;

            @Override
            public boolean isFinished() {
                try{
                    return reader.read() < 0;
                }catch (IOException e){
                    e.printStackTrace();
                }
                return false;
            }

            @Override
            public boolean isReady() {
                return isFinished();
            }

            @Override
            public void setReadListener(ReadListener listener) {
                this.readListener = listener;

                try{
                    if(!isFinished()){
                        readListener.onDataAvailable();
                    }else{
                        readListener.onAllDataRead();
                    }
                }catch (IOException io){
                    io.printStackTrace();
                }
            }

            @Override
            public int read() throws IOException {
                return reader.read();
            }
        };
    }
}
