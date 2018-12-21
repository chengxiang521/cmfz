package com.baizhi.cx;

import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CmfzApplicationTests {

    @Test
    public void text() {
        File file = new File("src/main/webapp/upload/0136137707746281.mp3");
        if (file.exists() && file.isFile()) {
            String fileName = file.getName();
            System.out.println("文件"+fileName+"的大小是："+(file.length()/1024+1));
        }
    }

}

