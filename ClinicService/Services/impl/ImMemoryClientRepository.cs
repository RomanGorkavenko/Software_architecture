using ClinicService.Models;

namespace ClinicService.Services.impl
{
    public class ImMemoryClientRepository : IClientRepository
    {
        int IRepository<Client, int>.Create(Client item)
        {
            throw new NotImplementedException();
        }

        int IRepository<Client, int>.Delete(int id)
        {
            throw new NotImplementedException();
        }

        List<Client> IRepository<Client, int>.GetAll()
        {
            throw new NotImplementedException();
        }

        Client IRepository<Client, int>.GetById(int id)
        {
            throw new NotImplementedException();
        }

        int IRepository<Client, int>.Update(Client item)
        {
            throw new NotImplementedException();
        }
    }
}
