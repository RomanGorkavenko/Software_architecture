using ClinicService.Models;
using Microsoft.Data.Sqlite;

namespace ClinicService.Services.impl
{
    public class PetRepository : IPetRepository
    {
        private const string connectionString = "Data Source = clinic.db;";

        public int Create(Pet item)
        {
            using (SqliteConnection connection = new SqliteConnection(connectionString))
            {
                connection.Open();
                // Прописываем в команду SQL-запрос на добавление данных
                SqliteCommand command = connection.CreateCommand();
                command.CommandText = "INSERT INTO clients(ClientId, Name, Birthday) VALUES(@ClientId, @Name, @Birthday)";
                command.Parameters.AddWithValue("@Document", item.ClientId);
                command.Parameters.AddWithValue("@SurName", item.Name);
                command.Parameters.AddWithValue("@FirstName", item.Birthday.Ticks);
                // подготовка команды к выполнению
                command.Prepare();
                // Выполнение команды
                return command.ExecuteNonQuery();
            }
        }

        public int Delete(int id)
        {
            throw new NotImplementedException();
        }

        public List<Pet> GetAll()
        {
            throw new NotImplementedException();
        }

        public Pet GetById(int id)
        {
            throw new NotImplementedException();
        }

        public int Update(Pet item)
        {
            using (SqliteConnection connection = new SqliteConnection(connectionString))
            {
                connection.Open();
                // Прописываем в команду SQL-запрос на добавление данных
                SqliteCommand command = connection.CreateCommand();
                command.CommandText = "UPDATE clients SET ClientId = @ClientId, Name = @Name, Birthday = @Birthday WHERE PetId=@PetId";
                command.Parameters.AddWithValue("@ClientId", item.PetId);
                command.Parameters.AddWithValue("@Document", item.ClientId);
                command.Parameters.AddWithValue("@SurName", item.Name);
                command.Parameters.AddWithValue("@FirstName", item.Birthday.Ticks);
                // подготовка команды к выполнению
                command.Prepare();
                // Выполнение команды
                return command.ExecuteNonQuery();
            }
        }
    }
}
