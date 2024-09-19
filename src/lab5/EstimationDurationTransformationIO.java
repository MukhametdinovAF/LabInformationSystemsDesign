package lab5;

import java.util.ArrayList;
import java.util.Arrays;

public class EstimationDurationTransformationIO { // Qп - Оценка продолжительности преобразования входного набора данных в выходной
    public static double [] actualConversionDuration (double [] arr) { // Tп
        double leftSide = arr[0]; // левый предел
        double rightSide = arr[1]; // правый предел
        double [] totalDuration = new double [200]; // массив 200 значений
        for (int i = 0; i < totalDuration.length; i++) {
            totalDuration[i] = leftSide + Math.random()*(rightSide-leftSide); // заполняем массив значениями
        }
        return totalDuration; // возвращаем заполненный массив
    }
    public static double estimateDuration (double [] arr) { // вычисляем усредненную оценку mkq по нескольким значениям
        return Arrays.stream(arr).sum()/arr.length; // возвращаем усредненную оценку
    }
    public static double estimationDurationIO (ArrayList <String> lines, double estimateDuration){ // Вычисляем Qп - Оценка продолжительности преобразования входного набора данных в выходной
        double acceptableTimeDuration = Double.parseDouble(lines.get(5)); // Тдопп - допустимое время преобразования
        if (estimateDuration <= acceptableTimeDuration){
            return 1; // верни 1, если Тп<=Тдопп
        }
        else {
            return acceptableTimeDuration/estimateDuration; // в противном случае верни результат Тдоп/Тп
        }
    }
}
