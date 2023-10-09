using ClinicService.Controllers;
using ClinicService.Models;
using ClinicService.Models.Requests;
using ClinicService.Services;
using Microsoft.AspNetCore.Mvc;
using Moq;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ClinicServiceTests
{
    public class ClientControllerTests
    {
        private ClientController _clientController;
        private Mock<IClientRepository> _mockClientRepository;

        public ClientControllerTests()
        {
            _mockClientRepository = new Mock<IClientRepository>();
            _clientController = new ClientController(_mockClientRepository.Object);
        }

        [Fact]
        public void GetAllClientsTest()
        {
            // [1.1] Подготовка данных для тестирования

            // [1.2]

            List<Client> list = new List<Client>();
            list.Add(new Client());
            list.Add(new Client());
            list.Add(new Client());


            _mockClientRepository.Setup(repository =>
                repository.GetAll()).Returns(list);

            // [2] Исполнение тестируемого метода
            var operationResult = _clientController.GetAll();

            // [3] Подготовка эталонного результата, проверка результата
            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<List<Client>>(((OkObjectResult)operationResult.Result).Value);

            _mockClientRepository.Verify(repository =>
                repository.GetAll(), Times.AtLeastOnce());
        }

        public static readonly object[][] CorrectCreateClientData =
        {
            new object[] { new DateTime(1985, 5, 20), "123 1234", "Иванов", "Андрей", "Сергеевич" },
            new object[] { new DateTime(1987, 2, 18), "123 2222", "Иванов", "Андрей", "Сергеевич" },
            new object[] { new DateTime(1979, 1, 22), "123 4321", "Иванов", "Андрей", "Сергеевич" },
        };

        [Theory]
        [MemberData(nameof(CorrectCreateClientData))]
        public void CreateClientTest(DateTime birthday, string document, string surName, string firstName, string patronymic)
        {
            _mockClientRepository.Setup(repository => repository
                .Create(It.IsNotNull<Client>()))
                .Returns(1).Verifiable();

            var operationResult = _clientController.Create(new CreateClientRequest
            {
                Birthday = birthday,
                Document = document,
                SurName = surName,
                FirstName = firstName,
                Patronymic = patronymic
            });

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);
            _mockClientRepository.Verify(repository => repository
                .Create(It.IsNotNull<Client>()), Times.AtLeastOnce());

        }

        [Fact]
        public void DeleteClientTest()
        {
            _mockClientRepository.Setup(repository => repository.Delete(1)).Returns(1);

            var operationResult = _clientController.Delete(1);

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);

            _mockClientRepository.Verify(repository => repository.Delete(1), Times.Once);
        }

        [Fact]
        public void GetClientByIdTest()
        {
            Client client = new Client();

            _mockClientRepository.Setup(repository => repository.GetById(1)).Returns(client);

            var operationResult = _clientController.GetById(1);

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<Client>(((OkObjectResult)operationResult.Result).Value);

            _mockClientRepository.Verify(repository => repository.GetById(1), Times.Once);
        }

        public static readonly object[][] CorrectUpdateClientData =
        {
            new object[] { 1, new DateTime(1985, 5, 20), "123 1234", "Иванов", "Андрей", "Сергеевич" },
            new object[] { 2, new DateTime(1987, 2, 18), "123 2222", "Иванов", "Андрей", "Сергеевич" },
            new object[] { 3, new DateTime(1979, 1, 22), "123 4321", "Иванов", "Андрей", "Сергеевич" },
        };

        [Theory]
        [MemberData(nameof(CorrectUpdateClientData))]
        public void UpdateClientTest(int IdClient, DateTime birthday, string document, string surName, string firstName, string patronymic)
        {
            _mockClientRepository.Setup(repository => repository
                .Update(It.IsNotNull<Client>()))
                .Returns(1).Verifiable();

            var operationResult = _clientController.Update(new UpdateClientRequest
            {
                ClientId = IdClient,
                Birthday = birthday,
                Document = document,
                SurName = surName,
                FirstName = firstName,
                Patronymic = patronymic
            });

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);
            _mockClientRepository.Verify(repository => repository
                .Update(It.IsNotNull<Client>()), Times.Once());

        }
    }
}
