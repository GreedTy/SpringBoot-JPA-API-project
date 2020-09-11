package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Builder
@Accessors(chain = true)
// **lombok 생성자와 설정자 패턴**
// @Builder AdminUser adminUser = new AdminUser();
// adminUser.builder().account(account).password(passowrd); << 생성자 생성
// @Accessors(chain = true)
// user.setEmail()
//     .setphoneNumeber() -> set을 나눠서하지않고 쭉 연결해서할 수 잇음 << update칠때 유용함 chaining패턴
//     .setAccount()
public class AdminUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String password;
    private String status;
    private String role;
    private LocalDateTime lastLoginAt;
    private LocalDateTime passwordUpdatedAt;
    private int loginFailCount;
    private LocalDateTime registeredAt;
    private LocalDateTime unregisteredAt;
    @CreatedDate
    private LocalDateTime createdAt;
    @CreatedBy
    private String createdBy;
    @LastModifiedDate
    private LocalDateTime updatedAt;
    @LastModifiedBy
    private String updatedBy;
}
