import java.util.Scanner;
import java.lang.IllegalArgumentException;

final class BookPagesGenerator
{
  private int pages;
  private int current_left_page;
  private int current_right_page;
  
  BookPagesGenerator(int pages)
  {
    this.pages = pages;
    this.current_left_page = pages / 2;
    this.current_right_page = current_left_page++;
  }
  
  public void show()
  {
    int pages = this.pages;
    int current_left_page = this.current_left_page;
    int current_right_page = this.current_right_page;
    
    if ((pages % 4 == 0) | (pages % 2 == 0))
    {
      while ((current_left_page > 0) && (current_right_page < pages))
      {
        current_left_page--;
        current_right_page++;
        
        System.out.print(current_left_page);
        System.out.print(" ");
        System.out.print(current_right_page);
        System.out.print("\n");
        
        if (current_left_page % 2 == 0)
        {
          System.out.print("--- Переверніть сторінку ---");
          System.out.print("\n");
        }
        else if ((current_left_page % 2 == 1) && (current_left_page >= 3))
        {
          System.out.print("*** Наступний лист ***");
          System.out.print("\n");
        }
      }
    }
  }
}

public class PagesGenerator
{
  public static void main(String[] args)
  {
    System.out.print("Будь ласка, введіть парне число сторінок книги: ");
    Scanner in = new Scanner(System.in);
    int number = in.nextInt();
    
    if (number % 2 == 0)
    {
      BookPagesGenerator p = new BookPagesGenerator(number);
      p.show();
    }
    else
    {
      try
      {
        throw new IllegalArgumentException("Неможливо використати непарне число");
      }
      catch (IllegalArgumentException e)
      {
        System.out.print(e.getMessage());
        System.out.print("\n");
      }
    }
  }
}
