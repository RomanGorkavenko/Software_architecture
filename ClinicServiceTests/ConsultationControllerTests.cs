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
    public class ConsultationControllerTests
    {

        private ConsultationController _ConsultationController;
        private Mock<IConsultationRepository> _mockConsultationRepository;

        public ConsultationControllerTests()
        {
            _mockConsultationRepository = new Mock<IConsultationRepository>();
            _ConsultationController = new ConsultationController(_mockConsultationRepository.Object);
        }

        public static readonly object[][] CorrectCreateConsultationData =
        {
            new object[] { 1, 1, new DateTime(2002, 3, 21), "описание" },
            new object[] { 2, 2, new DateTime(2010, 8, 10), "описание" },
            new object[] { 3, 3, new DateTime(2020, 12, 15), "описание" }
        };

        [Theory]
        [MemberData(nameof(CorrectCreateConsultationData))]
        public void CreateConsultationTest(int ClientId, int PetId, DateTime ConsultationDate, string description)
        {
            _mockConsultationRepository.Setup(repository => repository
                .Create(It.IsNotNull<Consultation>()))
                .Returns(1).Verifiable();

            var operationResult = _ConsultationController.Create(new CreateConsultationRequest
            {
                ClientId = ClientId,
                PetId = PetId,
                ConsultationDate = ConsultationDate,
                Description = description
            });

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);
            _mockConsultationRepository.Verify(repository => repository
                .Create(It.IsNotNull<Consultation>()), Times.Once());
        }

        public static readonly object[][] CorrectUpdateConsultationData =
        {
            new object[] { 1, 1, 1, new DateTime(2002, 3, 21), "описание" },
            new object[] { 2, 2, 2, new DateTime(2010, 8, 10), "описание" },
            new object[] { 3 ,3, 3, new DateTime(2020, 12, 15), "описание" }
        };

        [Theory]
        [MemberData(nameof(CorrectUpdateConsultationData))]
        public void UpdateConsultationTest(int ConsultationId, int ClientId, int PetId, DateTime ConsultationDate, string description)
        {
            _mockConsultationRepository.Setup(repository => repository
                .Update(It.IsNotNull<Consultation>()))
                .Returns(1).Verifiable();

            var operationResult = _ConsultationController.Update(new UpdateConsultationRequest
            {
                ConsultationId = ConsultationId,
                ClientId = ClientId,
                PetId = PetId,
                ConsultationDate = ConsultationDate,
                Description = description
            });

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);
            _mockConsultationRepository.Verify(repository => repository
                .Update(It.IsNotNull<Consultation>()), Times.Once());
        }

        [Fact]
        public void DeleteConsultationTest()
        {
            _mockConsultationRepository.Setup(repository => repository.Delete(1)).Returns(1);

            var operationResult = _ConsultationController.Delete(1);

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<int>(((OkObjectResult)operationResult.Result).Value);

            _mockConsultationRepository.Verify(repository => repository.Delete(1), Times.Once);
        }

        [Fact]
        public void GetAllConsultationsTest()
        {
            List<Consultation> list = new List<Consultation>();
            list.Add(new Consultation());
            list.Add(new Consultation());
            list.Add(new Consultation());

            _mockConsultationRepository.Setup(repository =>
                repository.GetAll()).Returns(list);

            var operationResult = _ConsultationController.GetAll();

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<List<Consultation>>(((OkObjectResult)operationResult.Result).Value);

            _mockConsultationRepository.Verify(repository =>
                repository.GetAll(), Times.Once());
        }

        [Fact]
        public void GetConsultationByIdTest()
        {
            Consultation pet = new Consultation();

            _mockConsultationRepository.Setup(repository => repository.GetById(1)).Returns(pet);

            var operationResult = _ConsultationController.GetById(1);

            Assert.IsType<OkObjectResult>(operationResult.Result);
            Assert.IsAssignableFrom<Consultation>(((OkObjectResult)operationResult.Result).Value);

            _mockConsultationRepository.Verify(repository => repository.GetById(1), Times.Once);
        }

    }
}
