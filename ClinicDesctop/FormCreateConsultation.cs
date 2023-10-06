using ClinicServiceNamespace;
using Newtonsoft.Json.Linq;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace ClinicDesctop
{
    public partial class FormCreateConsultation : Form
    {
        private bool isUpdate;

        private ClinicClient clinicClient = new ClinicClient("http://localhost:5299/", new HttpClient());

        public FormCreateConsultation(bool isUpdate)
        {
            InitializeComponent();
            Id.Enabled = isUpdate;
            this.isUpdate = isUpdate;
        }

        private void createConsultation(object sender, EventArgs e)
        {
            try
            {
                int clientId = (int)NumberClient.Value;
                int petId = (int)NumberPet.Value;

                string clientName = clinicClient.ClientGetByIdAsync(clientId).Result.FirstName;
                string petName = clinicClient.PetGetByIdAsync(petId).Result.Name;

                int countCreate = clinicClient.ConsultationCreateAsync(new CreateConsultationRequest
                {
                    ClientId = clientId,
                    PetId = petId,
                    ConsultationDate = dateTimeConsultation.Value,
                    Description = Description.Text
                }).Result;

                MessageBox.Show("Консультация для пользователя " +
                    clientName +
                    " и питомца " + petName +
                    " добавлена.",
                    "Добавлено " + countCreate + " консультаций");
                Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Ошибка создания консультации, проверьте заполняемые данные.",
                    "Ошибка",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error);
            }

        }

        private void updateConsultation(object sender, EventArgs e)
        {
            try
            {
                int value = (int)Id.Value;
                int clientId = (int)NumberClient.Value;
                int petId = (int)NumberPet.Value;

                string clientName = clinicClient.ClientGetByIdAsync(clientId).Result.FirstName;
                string petName = clinicClient.PetGetByIdAsync(petId).Result.Name;

                int countUpdate = clinicClient.ConsultationUpdateAsync(new UpdateConsultationRequest
                {
                    ConsultationId = value,
                    ClientId = clientId,
                    PetId = petId,
                    ConsultationDate = dateTimeConsultation.Value,
                    Description = Description.Text
                }).Result;

                if (countUpdate == 0)
                {
                    MessageBox.Show("Консультации c номером " + value + " несуществует",
                        "Ошибка",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                    return;
                }

                MessageBox.Show("Консультация для пользователя " +
                        clientName +
                        " и питомца " + petName +
                        " обновлена.",
                        "Оюновлено " + countUpdate + " консультаций");
                Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Ошибка создания консультации, проверьте заполняемые данные.",
                    "Ошибка",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error);
            }

        }

        private void cancel_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void save_Click(object sender, EventArgs e)
        {
            if (!isUpdate)
            {
                createConsultation(sender, e);
            }
            else
            {
                updateConsultation(sender, e);
            }
        }
    }
}
