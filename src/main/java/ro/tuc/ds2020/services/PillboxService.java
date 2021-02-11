package ro.tuc.ds2020.services;

import grpc.*;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.entities.MedicationHistory;
import ro.tuc.ds2020.repositories.MedicationHistoryRepository;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Service
@RequiredArgsConstructor
@Transactional
public class PillboxService extends PillboxServiceGrpc.PillboxServiceImplBase {
    private final MedicationHistoryRepository medicationHistoryRepository;

        @Override
        public void getMedicationPlans(MedicationPlanRequest request, StreamObserver<MedicationPlanResponse> responseObserver) {

            //availableMedicationPlan(request.getCurrentDate());
            MedicationPlanResponse.Builder response = MedicationPlanResponse.newBuilder();

                GRPCMedicationPlan.Builder currentMedPlanBuilder = GRPCMedicationPlan.newBuilder();

                currentMedPlanBuilder.setId(1);
                currentMedPlanBuilder.setPatientId(1);
                currentMedPlanBuilder.setStartDate(LocalDate.now().toString());
                currentMedPlanBuilder.setEndDate(LocalDate.now().plusDays(2).toString());
                if(availableMedicationPlan(request.getCurrentDate(), currentMedPlanBuilder.getStartDate(), currentMedPlanBuilder.getEndDate())) {


                    GRPCMedicationToMedicationPlan.Builder currentMedToMedPlanBuilder = GRPCMedicationToMedicationPlan.newBuilder();
                    currentMedToMedPlanBuilder.setId(1);
                    currentMedToMedPlanBuilder.setMedicationName("Augmentin");
                    currentMedToMedPlanBuilder.setIntakeInterval("09:00-12:00");

                    GRPCMedicationToMedicationPlan.Builder currentMedToMedPlanBuilder2 = GRPCMedicationToMedicationPlan.newBuilder();
                    currentMedToMedPlanBuilder2.setId(2);
                    currentMedToMedPlanBuilder2.setMedicationName("Paracetamol");
                    currentMedToMedPlanBuilder2.setIntakeInterval("09:00-10:00");

                    currentMedPlanBuilder.addGRPCMedicationToMedicationPlan(currentMedToMedPlanBuilder.build());
                    currentMedPlanBuilder.addGRPCMedicationToMedicationPlan(currentMedToMedPlanBuilder2.build());



                    //availableMedicationPlan(request.getCurrentDate(), currentMedPlanBuilder.getStartDate(), currentMedPlanBuilder.getEndDate());

                    response.addMedicationPlans(currentMedPlanBuilder.build());

                }

            responseObserver.onNext(response.build());
            responseObserver.onCompleted();
        }

    @Override
    public void sendPatientAction(GRPCMedicationAction request, StreamObserver<EmptyResponse> responseObserver) {
        Long medicationPlanId = request.getMedicationPlanId();
        String medicationName = request.getMedicationName();
        LocalDateTime time = LocalDateTime.now();
        boolean taken = request.getTaken();


        medicationHistoryRepository.save(new MedicationHistory(null, medicationPlanId, medicationName, time, taken));
        if(taken) {
            System.out.println("medication has been taken");
        }
        else {
            System.out.println("medication has not been taken");
        }
        responseObserver.onNext(EmptyResponse.newBuilder().build());
        responseObserver.onCompleted();
    }

    private boolean availableMedicationPlan(String date, String start, String end) {
        LocalDate sendDate = LocalDate.parse(date);
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);

        if (startDate.isEqual(sendDate) || endDate.isEqual(sendDate)) {
            return true;
        }
        return startDate.isBefore(sendDate) && sendDate.isBefore(endDate);
    }
    }
