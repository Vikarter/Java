package academy.tochkavhoda.introduction;

public class ZeroSteps2 {

    //Возвращает сумму квадратов целых чисел от 1 до count
    public int sumSquares(int count)
    {
        int sum=0;
        for(int i = 1;i <= count; i++)
        {
            sum += i*i;
        }
        return sum;
    }

    //Возвращает сумму нечетных целых чисел от 1 до count
    public int sumOdds(int count)
    {
        int sum = 0;
        for(int i = 1;i <= count; i++)
        {
            if(i % 2 !=0)
            {
                sum += i;
            }
        }
        return sum;
    }

}

