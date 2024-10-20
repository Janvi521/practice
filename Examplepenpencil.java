class Examplepenpencil
{
public static void main(String[] args)
{
int totalR = 100;
int penR = 15;
int pencilR = 3;
int no_pen ,no_pencil,amountPen,remainAmountPencil;
amountPen = totalR - penR; 
no_pen =( amountPen )/penR;
remainAmountPencil= totalR - amountPen;
no_pencil = remainAmountPencil/pencilR;
System.out.println("number of pen =  "+no_pen+"\n"+"number of pencil = "+no_pencil);

}
}