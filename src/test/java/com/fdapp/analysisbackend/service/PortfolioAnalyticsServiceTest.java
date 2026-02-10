// package com.fdapp.analysisbackend.service;

// import com.fdapp.analysisbackend.model.InvestmentProduct;
// import com.fdapp.analysisbackend.model.Portfolio;
// import com.fdapp.analysisbackend.model.Transaction;
// import com.fdapp.analysisbackend.dto.PortfolioSummaryDTO;
// import com.fdapp.analysisbackend.dto.AllocationDTO;
// import com.fdapp.analysisbackend.dto.GainLossDTO;
// import com.fdapp.analysisbackend.repository.PortfolioRepository;
// import com.fdapp.analysisbackend.repository.TransactionRepository;
// import com.fdapp.analysisbackend.repository.InvestmentProductRepository;
// import com.fdapp.analysisbackend.enums.InvestmentType;

// import org.junit.jupiter.api.BeforeEach;
// import org.junit.jupiter.api.Test;
// import org.mockito.InjectMocks;
// import org.mockito.Mock;
// import org.mockito.MockitoAnnotations;

// import java.math.BigDecimal;
// import java.time.LocalDateTime;
// import java.util.*;

// import static org.junit.jupiter.api.Assertions.*;
// import static org.mockito.Mockito.*;

// public class PortfolioAnalyticsServiceTest {

//     @InjectMocks
//     private PortfolioAnalyticsService service;

//     @Mock
//     private PortfolioRepository portfolioRepo;

//     @Mock
//     private TransactionRepository transactionRepo;

//     @Mock
//     private InvestmentProductRepository productRepo;

//     private UUID userId;

//     @BeforeEach
//     public void setup() {
//         MockitoAnnotations.openMocks(this); // initialize mocks
//         userId = UUID.randomUUID();         // random user id for tests
//     }

//     @Test
//     public void testGetSummary_withData() {
//         // Mock investment product
//         InvestmentProduct product = new InvestmentProduct();
//         product.setType(InvestmentType.Stock); // correct enum
//         product.setCurrentNAV(new BigDecimal("50"));

//         // Mock portfolio
//         Portfolio portfolio = new Portfolio();
//         portfolio.setUnitsOwned(new BigDecimal("10"));
//         portfolio.setAvgPurchasePrice(new BigDecimal("40"));
//         portfolio.setInvestmentProduct(product);

//         when(portfolioRepo.findByUser_Id(userId)).thenReturn(Arrays.asList(portfolio));

//         // Mock transaction
//         Transaction txn = new Transaction();
//         txn.setTxnDate(LocalDateTime.now().minusDays(10));
//         when(transactionRepo.findByUser_Id(userId)).thenReturn(Arrays.asList(txn));

//         // Call service
//         PortfolioSummaryDTO dto = service.getSummary(userId);

//         // Assertions
//         assertEquals(400.0, dto.getTotalInvested(), 0.001);
//         assertEquals(500.0, dto.getCurrentValue(), 0.001);
//         assertEquals(100.0, dto.getTotalGainLoss(), 0.001);
//         assertTrue(dto.getAbsoluteReturnPercent() > 0);
//         assertTrue(dto.getAnnualizedReturnPercent() > 0);
//     }

//     @Test
//     public void testGetAllocation_withMultipleTypes() {
//         // Mock products
//         InvestmentProduct p1 = new InvestmentProduct();
//         p1.setType(InvestmentType.Stock);
//         p1.setCurrentNAV(new BigDecimal("50"));

//         InvestmentProduct p2 = new InvestmentProduct();
//         p2.setType(InvestmentType.Bond);
//         p2.setCurrentNAV(new BigDecimal("100"));

//         // Mock portfolios
//         Portfolio port1 = new Portfolio();
//         port1.setUnitsOwned(new BigDecimal("2"));
//         port1.setInvestmentProduct(p1);

//         Portfolio port2 = new Portfolio();
//         port2.setUnitsOwned(new BigDecimal("1"));
//         port2.setInvestmentProduct(p2);

//         when(portfolioRepo.findByUser_Id(userId)).thenReturn(Arrays.asList(port1, port2));

//         // Call service
//         List<AllocationDTO> allocations = service.getAllocation(userId);

//         // Assertions
//         assertEquals(2, allocations.size());
//         assertTrue(allocations.stream().anyMatch(a -> a.getInvestmentType().equals("Stock")));
//         assertTrue(allocations.stream().anyMatch(a -> a.getInvestmentType().equals("Bond")));
//     }

//     @Test
//     public void testGetGains_withEmptyPortfolio() {
//         when(portfolioRepo.findByUser_Id(userId)).thenReturn(Collections.emptyList());

//         List<GainLossDTO> gains = service.getGains(userId);

//         assertTrue(gains.isEmpty());
//     }
// }
