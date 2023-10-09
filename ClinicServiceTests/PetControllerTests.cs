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
    public class PetControllerTests
    {
        private PetController _petController;
        private Mock<IPetRepository> _mockPetRepository;

        public PetControllerTests()
        {
            _mockPetRepository = new Mock<IPetRepository>();
            _petController = new PetController(_mockPetRepository.Object);
        }

        public static readonly object[][] CorrectCreatePetData =
        {
            new object[] { 1, "Бобик", new DateTime(2002, 3, 21) },
            new object[] { 2, "Шарик", new DateTime(2010, 8, 10) },
            new object[] { 3, "Василий", new DateTime(2020, 12, 15) }
        };

        [Theory]
        [MemberData(nameof(CorrectCreatePetData))]
        public void CreatePetTest(int ClientId, string name, DateTime birthday)
        {
            _mockPetRepository.Setup(repository => repository
                .Create(It.IsNotNull<Pet>()))
                .Returns(1).Verifiable();

            var operationResult = _petController.Create(new CreatePetRequest
            {
                ClientId = ClientId,
                Name = name,
                Birthday = birthday
            });

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);
            _mockPetRepository.Verify(repository => repository
                .Create(It.IsNotNull<Pet>()), Times.Once());
        }

        public static readonly object[][] CorrectUpdatePetData =
        {
            new object[] { 3, 1, "Бобик", new DateTime(2002, 3, 21) },
            new object[] { 1, 2, "Шарик", new DateTime(2010, 8, 10) },
            new object[] { 2, 3, "Василий", new DateTime(2020, 12, 15) }
        };

        [Theory]
        [MemberData(nameof(CorrectUpdatePetData))]
        public void UpdatePetTest(int PetId, int ClientId, string name, DateTime birthday)
        {
            _mockPetRepository.Setup(repository => repository
                .Update(It.IsNotNull<Pet>()))
                .Returns(1).Verifiable();

            var operationResult = _petController.Update(new UpdatePetRequest
            {
                PetId = PetId,
                ClientId = ClientId,
                Name = name,
                Birthday = birthday
            });

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);
            _mockPetRepository.Verify(repository => repository
                .Update(It.IsNotNull<Pet>()), Times.Once());
        }

        [Fact]
        public void DeletePetTest()
        {
            _mockPetRepository.Setup(repository => repository.Delete(1)).Returns(1);

            var operationResult = _petController.Delete(1);

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);

            _mockPetRepository.Verify(repository => repository.Delete(1), Times.Once);
        }

        [Fact]
        public void GetAllPetsTest()
        {
            List<Pet> list = new List<Pet>();
            list.Add(new Pet());
            list.Add(new Pet());
            list.Add(new Pet());

            _mockPetRepository.Setup(repository =>
                repository.GetAll()).Returns(list);

            var operationResult = _petController.GetAll();

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<List<Pet>>(((OkObjectResult)operationResult.Result).Value);

            _mockPetRepository.Verify(repository =>
                repository.GetAll(), Times.Once());
        }

        [Fact]
        public void GetPetByIdTest()
        {
            Pet pet = new Pet();

            _mockPetRepository.Setup(repository => repository.GetById(1)).Returns(pet);

            var operationResult = _petController.GetById(1);

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<Pet>(((OkObjectResult)operationResult.Result).Value);

            _mockPetRepository.Verify(repository => repository.GetById(1), Times.Once);
        }
    }
}
