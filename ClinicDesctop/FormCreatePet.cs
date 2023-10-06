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

namespace ClinicDesctop
{
    public partial class FormCreatePet : Form
    {
        private bool isUpdate;

        private ClinicClient clinicClient = new ClinicClient("http://localhost:5299/", new HttpClient());

        public FormCreatePet(bool isUpdate)
        {
            InitializeComponent();
            PetId.Enabled = isUpdate;
            this.isUpdate = isUpdate;
        }

        private void cancel_Click(object sender, EventArgs e)
        {
            Close();
        }

        private void save_Click(object sender, EventArgs e)
        {
            if (!isUpdate)
            {
                createPet(sender, e);
            }
            else
            {
                updatePet(sender, e);
            }
        }

        private void createPet(object sender, EventArgs e)
        {
            try
            {
                int clientId = (int)ClientId.Value;

                string clientName = clinicClient.ClientGetByIdAsync(clientId).Result.FirstName;

                int countCreate = clinicClient.PetCreateAsync(new CreatePetRequest
                {
                    ClientId = clientId,
                    Name = name.Text,
                    Birthday = dateTimeBirthday.Value
                }).Result;

                MessageBox.Show("Питомец " +
                        name.Text +
                        " создан. " +
                        " Хозяин " +
                        clientName,
                        "Создано " + countCreate + " питомцев");
                Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Ошибка создания питомца, проверьте заполняемые данные.",
                    "Ошибка",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error);
            }

        }

        private void updatePet(object sender, EventArgs e)
        {
            try
            {
                int value = (int)PetId.Value;
                int clientId = (int)ClientId.Value;

                string clientName = clinicClient.ClientGetByIdAsync(clientId).Result.FirstName;

                int countUpdate = clinicClient.PetUpdateAsync(new UpdatePetRequest
                {
                    PetId = value,
                    ClientId = clientId,
                    Name = name.Text,
                    Birthday = dateTimeBirthday.Value
                }).Result;

                if (countUpdate == 0)
                {
                    MessageBox.Show("Питомца  c номером " + value + " несуществует",
                        "Ошибка",
                        MessageBoxButtons.OK,
                        MessageBoxIcon.Error);
                    return;
                }

                MessageBox.Show("Питомец " +
                        name.Text +
                        " обновлен. " +
                        " Хозяин " +
                        clientName,
                        "Обновлено " + countUpdate + " питомцев");
                Close();
            }
            catch (Exception ex)
            {
                MessageBox.Show("Ошибка создания питомца, проверьте заполняемые данные.",
                    "Ошибка",
                    MessageBoxButtons.OK,
                    MessageBoxIcon.Error);
            }

        }
    }
}
