using ClinicServiceNamespace;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Xml.Linq;

namespace ClinicDesctop
{
    public partial class Delete : Form
    {
        private ClinicClient clinicClient = new ClinicClient("http://localhost:5299/", new HttpClient());

        private int radioButton;

        public Delete(int numberData)
        {
            InitializeComponent();
            radioButton = numberData;

            if (numberData == 1)
            {
                numberTitle.Text = "Введите № консультации,\r\nкоторую хотите удалить";
            }
            if (numberData == 2)
            {
                numberTitle.Text = "Введите № клиента,\r\nкоторого хотите удалить";
            }
            if (numberData == 3)
            {
                numberTitle.Text = "Введите № питомца,\r\nкоторого хотите удалить";
            }
        }

        private void cancel_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if (radioButton == 1)
            {
                int value = (int)numericUpDown1.Value;

                try
                {
                    Consultation consultation = clinicClient.ConsultationGetByIdAsync(value).Result;
                    string nameClient = clinicClient.ClientGetByIdAsync(consultation.ClientId).Result.FirstName;
                    string namePet = clinicClient.PetGetByIdAsync(consultation.PetId).Result.Name;

                    int countDelete = clinicClient.ConsultationDeleteAsync(value).Result;
                    Close();
                    MessageBox.Show("Консультация для " + nameClient + " с питомцем " + namePet + " удалена.",
                        "Удалено " + countDelete + " консультаций");
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Консультации c номером " + value + " несуществует",
                        "Ошибка",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                }
            }
            if (radioButton == 2)
            {
                int value = (int)numericUpDown1.Value;

                try
                {
                    Client client = clinicClient.ClientGetByIdAsync(value).Result;
                    string name = client.FirstName;
                    string lastName = client.SurName;

                    int countDelete = clinicClient.ClientDeleteAsync(value).Result;
                    Close();
                    MessageBox.Show("Пользователь " + name + " " + lastName + " удален.", "Удалено "
                    + countDelete + " пользователей");
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Пользователь c номером " + value + " несуществует",
                        "Ошибка",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                }
            }
            if (radioButton == 3)
            {
                int value = (int)numericUpDown1.Value;

                try
                {
                    Pet pet = clinicClient.PetGetByIdAsync(value).Result;
                    string nameClient = clinicClient.ClientGetByIdAsync(pet.ClientId).Result.FirstName;
                    string namePet = pet.Name;

                    int countDelete = clinicClient.PetDeleteAsync(value).Result;
                    Close();
                    MessageBox.Show("Питомец " + namePet + " удален.",
                        "Удалено " + countDelete + " питомцев");
                }
                catch (Exception ex)
                {
                    MessageBox.Show("Питомца c номером " + value + " несуществует",
                        "Ошибка",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                }
            }
        }
    }
}
