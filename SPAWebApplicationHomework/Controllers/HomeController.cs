using Microsoft.AspNetCore.Mvc;
using SPAWebApplicationHomework.Models;

namespace SPAWebApplicationHomework.Controllers
{
    public class HomeController : Controller
    {
        public IActionResult Home()
        {
            List<Film> films = new List<Film>();
            films.Add(new Film
            {
                Name = "Индиана Джонс и колесо судьбы",
                Description = "Неувядающий авантюрист и пытливый археолог-исследователь" +
                "по-прежнему в седле. На этот раз ему придётся столкнуться с непростой задачей," +
                "которую решить на раз-два вряд ли получится. Но Индиана Джонс не даст слабину" +
                "и не отступит при виде даже самой безнадёжной ситуации."
            });
            films.Add(new Film
            {
                Name = "Убийцы цветочной луны",
                Description = "Вскоре после Первой мировой Эрнест Беркхарт," +
                "отслуживший во Франции поваром, приезжает искать удачи в Оклахому," +
                "где находится крупная резервация индейцев племени осейдж." +
                "В тех краях живет его дядя Уильям Хэйл, который носит прозвище Король — он…"
            });
            films.Add(new Film
            {
                Name = "Стражи Галактики. Часть 3",
                Description = "Едва Стражи Галактики обосновываются на Забвении," +
                "на них нападает Адам Уорлок, обладающее сверхспособностями существо," +
                "созданное своей «матерью» и Верховной Жрицей суверенов Аишей." +
                "В бою Небуле удаётся победить Адама, но Ракета получает серьёзные…"
            });

            return View(films);
        }

        public IActionResult About()
        {
            return View();
        }

        public IActionResult Contact()
        {
            return View();
        }

        public IActionResult Auth()
        {
            return View();
        }
    }
}
