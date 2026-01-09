package pairmatching.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {
    private static final String BACK_FILE_NAME = "backend-crew.md";
    private static final String FRONT_FILE_NAME = "frontend-crew.md";

    public List<String> readBackEndCrews() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(BACK_FILE_NAME);

        if (inputStream == null) {
            throw new IllegalArgumentException(BACK_FILE_NAME + "을 classpath에서 찾을 수 없습니다.");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines()
                    .filter(line -> !line.isBlank())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException(BACK_FILE_NAME + " 파일을 읽는 과정에서 오류가 발생했습니다.", e);
        }
    }

    public List<String> readFrontEndCrews() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(FRONT_FILE_NAME);

        if (inputStream == null) {
            throw new IllegalArgumentException(FRONT_FILE_NAME + "을 classpath에서 찾을 수 없습니다.");
        }

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            return reader.lines()
                    .filter(line -> !line.isBlank())
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException(FRONT_FILE_NAME + " 파일을 읽는 과정에서 오류가 발생했습니다.", e);
        }
    }
}
